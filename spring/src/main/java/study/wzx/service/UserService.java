package study.wzx.service;

import study.spring.AutoWired;
import study.spring.BeanNameAware;
import study.spring.Component;
import study.spring.InitializingBean;
import study.spring.Scope;

/**
 * @author 1205869
 * @version Id: UserService, v 0.1 2022/8/21 8:11 PM 1205869 Exp $
 */
@Component("userService")
@Scope("prototype")
public class UserService implements BeanNameAware, InitializingBean {

    @AutoWired
    private OrderService orderService;

    private String beanName;

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
