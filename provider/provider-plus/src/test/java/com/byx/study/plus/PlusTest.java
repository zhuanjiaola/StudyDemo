package com.byx.study.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byx.study.plus.entity.AirQualityIndex;
import com.byx.study.plus.mapper.AirQualityIndexMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlusTest {

    @Autowired
    private AirQualityIndexMapper mapper;

    @Test
    public void test01() {
        List<AirQualityIndex> airQualityIndices = mapper.selectList(null);
        for (AirQualityIndex airQualityIndex : airQualityIndices) {
            System.out.println(airQualityIndex);
        }
    }

    @Test
    public void selectOneTest() {
        QueryWrapper<AirQualityIndex> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 3L);
        System.out.println(mapper.selectOne(wrapper));
    }

    @Test
    public void selectCountTest() {
        QueryWrapper<AirQualityIndex> wrapper = new QueryWrapper<>();
        wrapper.eq("pm10", 36);
//        System.out.println(mapper.selectCount(wrapper));
        for (AirQualityIndex airQualityIndex : mapper.selectList(wrapper)) {
            System.out.println(airQualityIndex);
        }
    }

    @Test
    public void selectPageTest() {
        Page<AirQualityIndex> page = new Page<>(1, 2);
        Page<AirQualityIndex> page1 = mapper.selectPage(page, null);
//        for (AirQualityIndex record : page1.getRecords()) {
//            System.out.println(record);
//        }
        page1.getRecords().forEach(System.out::println);
//        System.out.println(page1.getCurrent());
//        System.out.println(page1.getSize());
//        System.out.println(page1.getTotal());
    }

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void restTemplateTest() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "'application/x-www-form-urlencoded");
        headers.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzZWN1cmUtYXBpIiwiYXVkIjoic2VjdXJlLWFwcCIsInN1YiI6InhwMSIsImp0aSI6ImNmNWE2N2RlLWJhMTgtNDMxNi1iYTkzLTFjN2I4M2Q5Njg3OSIsInJvbCI6WyJST0xFX1VTRVIiXSwicGxpIjoxfQ.S0CMaRvJBmAxphWKN7HCtrhU0nTN061yh_1vAEDFxI0");
        String s = restTemplate.postForObject("http://localhost:8088/cl/parkinglot/findAll", new HttpEntity<String>(headers), String.class);
        System.out.println(s);
    }


}
