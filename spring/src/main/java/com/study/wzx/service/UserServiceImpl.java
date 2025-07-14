package com.study.wzx.service;

import com.study.spring.AutoWired;
import com.study.spring.BeanNameAware;
import com.study.spring.Component;
import com.study.spring.InitializingBean;
import com.study.spring.Scope;

/**
 * @author 1205869
 * @version Id: UserService, v 0.1 2022/8/21 8:11 PM 1205869 Exp $
 */
@Component("userService")
@Scope("prototype")
public class UserServiceImpl implements BeanNameAware, InitializingBean, UserService {

    @AutoWired
    private OrderService orderService;

    private String       beanName;

    /**
     * 设置Bean的名称
     * @param name Bean的名称
     */
    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    /**
     * 初始化方法，用于在Bean属性设置完成后执行自定义初始化逻辑
     * @throws Exception 初始化过程中发生的异常
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }

    /**
     * 测试方法
     */
    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
    }

}
