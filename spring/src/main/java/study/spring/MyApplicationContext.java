package study.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 1205869
 * @version Id: ZhenXingApplicationContext, v 0.1 2022/8/21 8:02 PM 1205869 Exp $
 */
public class MyApplicationContext {

    private Class configClass;

    // 单例池
    private ConcurrentHashMap<String, Object> singletonObjectMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public MyApplicationContext(Class configClass) {
        this.configClass = configClass;
        // 解析配置类
        scan(configClass);

        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjectMap.put(beanName, bean);
            }


        }

    }

    private Object createBean(String beanName,BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            // 依赖注入
            for (Field field : beanDefinition.getClazz().getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoWired.class)) {
                    Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }
            // aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }
            // 初始化
            if (instance instanceof InitializingBean) {
                try {
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 扫描
     * @param configClass
     */
    private void scan(Class configClass) {
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();
        path = path.replace(".", "/");

        ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class")).replace("/", ".");
                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            // 放入作用域
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 获取bean对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object o = singletonObjectMap.get(beanName);
                return o;
            } else {
                // 创建对象
                return createBean(beanName, beanDefinition);
            }
        } else {
            throw new NullPointerException();
        }
    }

}
