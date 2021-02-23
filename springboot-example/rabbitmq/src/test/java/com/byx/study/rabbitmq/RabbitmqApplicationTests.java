package com.byx.study.rabbitmq;

import com.byx.study.rabbitmq.provider.HelloRabbitProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitmqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private HelloRabbitProvider provider;

    @Test
    void test01() {
        for (int i = 0; i < 20; i++) {
            provider.send();
        }
    }

}
