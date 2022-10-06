package com.byx.study.rabbitmq;

import com.byx.study.rabbitmq.provider.HelloRabbitProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class RabbitmqApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private HelloRabbitProvider helloRabbitProvider;

    @Test
    public void test01() {
        for (int i = 0; i < 20; i++) {
            helloRabbitProvider.send();
        }
    }

}
