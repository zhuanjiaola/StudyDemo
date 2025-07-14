package com.study.spring;

/**
 * @author 1205869
 * @version Id: InitializeBean, v 0.1 2022/8/26 9:31 PM 1205869 Exp $
 */
public interface InitializingBean {
    /**
     * 初始化方法，用于在Bean属性设置完成后执行自定义初始化逻辑
     * @throws Exception 初始化过程中发生的异常
     */
    void afterPropertiesSet() throws Exception;
}
