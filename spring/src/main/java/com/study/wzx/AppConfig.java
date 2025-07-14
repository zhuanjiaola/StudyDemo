package com.study.wzx;

import com.study.spring.ComponentScan;

/**
 * spring容器配置类，根据ComponentScan注解，用来定义需要扫描的包路径
 * @author 1205869
 * @version Id: AppConfig, v 0.1 2022/8/21 8:07 PM 1205869 Exp $
 */
@ComponentScan("com.study.wzx.service")
public class AppConfig {

}
