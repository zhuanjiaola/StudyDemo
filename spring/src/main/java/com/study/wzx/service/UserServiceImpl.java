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

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }

    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
    }

}
