package com.study.wzx.service;

import com.study.spring.BeanPostProcessor;
import com.study.spring.Component;
import com.study.spring.Scope;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author 1205869
 * @version Id: MyBeanPostProcessor, v 0.1 2022/8/26 10:11 PM 1205869 Exp $
 */
@Component("myBeanPostProcessor")
@Scope("prototype")
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在初始化方法之前执行
     * @param bean  待初始化的对象
     * @param beanName 对象名
     * @return 初始化之后的对象
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前");
        if (beanName.equals("userService")) {
            ((UserServiceImpl) bean).setBeanName("hello");
        }
        return bean;
    }

    /**
     * 在初始化方法之后执行
     * @param bean  待初始化的对象
     * @param beanName 待初始化的对象名
     * @return 初始化之后的对象
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后");
        if (beanName.equals("userService")) {
            Object newProxyInstance = Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(new Date());
                    return method.invoke(bean, args);
                }
            });
            return newProxyInstance;
        }
        return bean;
    }
}
