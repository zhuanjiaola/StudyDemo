package com.byx.study.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlusProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlusProviderApplication.class, args);
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
