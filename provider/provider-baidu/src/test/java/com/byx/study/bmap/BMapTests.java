package com.byx.study.bmap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BMapTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test01() {
        String url = "http://api.map.baidu.com/traffic/v1/road?road_name=东二环&city=北京市&ak=MI61wmfmx2ilTR1LSkxDGScLz3sGQKmI";
        System.out.println(restTemplate.getForObject(url, String.class));
    }

}
