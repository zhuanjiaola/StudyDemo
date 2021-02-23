package com.byx.study.rabbitmq.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wang zhen xing
 * @date 2021/2/23 16:07
 */
@Component
public class HelloRabbitProvider {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void send() {
        String msg = "hello " + new Date();
        System.out.println("provider: " + msg);
        amqpTemplate.convertAndSend("helloRabbit",msg);
    }


}
