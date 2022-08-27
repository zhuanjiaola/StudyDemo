package com.study.spring;

/**
 * @author 1205869
 * @version Id: BeanDefinition, v 0.1 2022/8/21 9:59 PM 1205869 Exp $
 */
public class BeanDefinition {
    private Class clazz;

    private String scope;

    public BeanDefinition() {
    }

    public BeanDefinition(Class clazz, String scope) {
        this.clazz = clazz;
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
