package com.study.wzx;

import com.study.spring.MyApplicationContext;
import com.study.wzx.service.UserService;
import com.study.wzx.service.UserServiceImpl;

/**
 * @author 1205869
 * @version Id: Test, v 0.1 2022/8/21 8:06 PM 1205869 Exp $
 */
public class Test {
    public static void main(String[] args) {
        MyApplicationContext applicationContext = new MyApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
        System.out.println();
        userService.test();
    }

}
