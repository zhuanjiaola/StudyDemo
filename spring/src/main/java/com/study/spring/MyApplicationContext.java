package com.study.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类功能描述：IOC容器，上下文类，完成bean的创建，初始化，依赖注入，属性赋值，bean处理器等功能
 * @author 1205869
 * @version Id: ZhenXingApplicationContext, v 0.1 2022/8/21 8:02 PM 1205869 Exp $
 */
public class MyApplicationContext {

    private Class                                           configClass;

    // 单例对象池
    private final ConcurrentHashMap<String, Object>         singletonObjectMap    = new ConcurrentHashMap<>();

    // bean定义信息map，key：beanName，value：beanDefinition
    private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap     = new ConcurrentHashMap<>();

    // bean处理器集合
    private final List<BeanPostProcessor>                   beanPostProcessorList = new ArrayList<>();

    /**
     * 构造方法
     * @param configClass 配置类
     */
    public MyApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 解析配置类
        scan(configClass);

        // 初始化单例bean
        initSingletonBean();
    }

    /**
     * 扫描
     * @param configClass
     */
    private void scan(Class configClass) {
        // 获取config类上的ComponentScan注解
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        // 获取ComponentScan注解值，即包路径
        String path = componentScanAnnotation.value().replace(".", "/");

        // 获取当前类的加载器
        ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
        // 获取包路径下的文件
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        // 判断是否是目录
        if (file.isDirectory()) {
            // 获取目录中的文件和子目录
            File[] files = file.listFiles();
            // 遍历文件中的类
            for (File f : files) {
                // 获取文件的绝对路径
                String fileName = f.getAbsolutePath();
                // 判断是否是class文件
                if (fileName.endsWith(".class")) {
                    // 根据文件名获取类名
                    // 如：/Users/mogo/IdeaProjects/study/StudyDemo/spring/target/classes/com/study/wzx/service/MyBeanPostProcessor.class -》com.study.wzx.service.MyBeanPostProcessor
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class")).replace("/", ".");
                    try {
                        // 加载class，获取class信息
                        Class<?> clazz = classLoader.loadClass(className);
                        // 判断类上是否有Component注解
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 获取该类上的Component注解信息
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            // 获取bean名称
                            String beanName = componentAnnotation.value();

                            // 创建bean定义信息
                            BeanDefinition beanDefinition = new BeanDefinition();
                            // 设置 类clazz
                            beanDefinition.setClazz(clazz);
                            // 设置 作用域scope
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            }
                            // spring的bean默认是单例
                            else {
                                beanDefinition.setScope("singleton");
                            }
                            // 放入bean定义信息map中
                            beanDefinitionMap.put(beanName, beanDefinition);

                            // 判断clazz是否是BeanPostProcessor的子类，如果是则直接创建bean对象，并将bean放入bean处理器集合中
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                beanPostProcessorList.add((BeanPostProcessor) getBean(beanName));
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 初始化单例bean
     */
    private void initSingletonBean() {
        // 遍历bean定义信息map，获取单例bean定义信息
        for (String beanName : beanDefinitionMap.keySet()) {
            // 获取bean定义信息
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            // 若作用域是单例，则创建bean对象，并将bean放入单例对象池中
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjectMap.put(beanName, bean);
            }
        }
    }

    /**
     * 创建bean
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        try {
            // 1.获取class，利用反射创建对象
            Class clazz = beanDefinition.getClazz();
            Object instance = clazz.newInstance();
            // 2.依赖注入
            // 获取所有属性
            for (Field field : clazz.getDeclaredFields()) {
                // 判断属性上是否有Autowired注解
                if (field.isAnnotationPresent(AutoWired.class)) {
                    Object bean = getBean(field.getName());
                    // 暴力访问
                    field.setAccessible(true);
                    // 注入属性
                    field.set(instance, bean);
                }
            }
            // 3.aware回调，设置bean名称
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            // 4.初始化前处理
            for (BeanPostProcessor processor : beanPostProcessorList) {
                // 调用初始化前方法，进行初始化前置处理
                instance = processor.postProcessBeforeInitialization(instance, beanName);
            }

            // 5.初始化中处理
            if (instance instanceof InitializingBean) {
                try {
                    // 调用afterPropertiesSet方法，进行初始化
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 6.初始化后处理
            for (BeanPostProcessor processor : beanPostProcessorList) {
                // 调用初始化后方法，进行初始化后处理
                instance = processor.postProcessAfterInitialization(instance, beanName);
            }

            // 7.返回bean对象
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取bean对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            // 单例bean直接获取
            if (beanDefinition.getScope().equals("singleton")) {
                return singletonObjectMap.get(beanName);
            } else {
                // 创建对象
                return createBean(beanName, beanDefinition);
            }
        } else {
            throw new NullPointerException();
        }
    }

}
