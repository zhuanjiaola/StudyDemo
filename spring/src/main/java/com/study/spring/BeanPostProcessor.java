package com.study.spring;

/**
 * @author 1205869
 * @version Id: BeanPostProcessor, v 0.1 2022/8/26 9:56 PM 1205869 Exp $
 */
public interface BeanPostProcessor {
    /**
     * 在初始化方法之前执行
     * @param bean  待初始化的对象
     * @param beanName 对象名
     * @return 初始化之后的对象
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 在初始化方法之后执行
     * @param bean  待初始化的对象
     * @param beanName 待初始化的对象名
     * @return 初始化之后的对象
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
