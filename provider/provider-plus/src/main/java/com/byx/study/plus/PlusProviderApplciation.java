package com.byx.study.plus;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;

@SpringBootApplication
public class PlusProviderApplciation {
    public static void main(String[] args) {
        SpringApplication.run(PlusProviderApplciation.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
//BeanFactory;
//    FactoryBean;
//    ApplicationContext;
//    DispatcherServlet
//    HashMap

}
