package com.study.spring;

/**
 * @author 1205869
 * @version Id: BeanPostProcessor, v 0.1 2022/8/26 9:56 PM 1205869 Exp $
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
