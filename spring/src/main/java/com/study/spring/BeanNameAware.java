package com.study.spring;

/**
 * @author 1205869
 * @version Id: BeanNameAware, v 0.1 2022/8/26 9:22 PM 1205869 Exp $
 */
public interface BeanNameAware {

    /**
     * 设置bean名称
     * @param name bean名称
     */
    void setBeanName(String name);

}
