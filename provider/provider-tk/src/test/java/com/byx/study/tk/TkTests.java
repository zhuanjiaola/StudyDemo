package com.byx.study.tk;

import com.byx.study.tk.entity.AirQualityIndex;
import com.byx.study.tk.mapper.AirQualityIndexMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class TkTests {

    @Resource
    private AirQualityIndexMapper airQualityIndexMapper;

    @Test
    public void test() {

    }

    @Test
    public void test01() {
//        List<AirQualityIndex> airQualityIndices = airQualityIndexMapper.selectAll();
//        for (AirQualityIndex airQualityIndex : airQualityIndices) {
//            System.out.println(airQualityIndex);
//        }

        Example example = new Example(AirQualityIndex.class);
        example.createCriteria().andEqualTo("id", 3);
        System.out.println(airQualityIndexMapper.selectByExample(example));
    }

    @Test
    public void test02() {
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        };
//        Comparator<Integer> comparator = Integer::compare;
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }


    @Test
    public void test03() {
        List<AirQualityIndex> airQualityIndices = Arrays.asList(
                new AirQualityIndex(),
                new AirQualityIndex(),
                new AirQualityIndex(),
                new AirQualityIndex()
        );


    }


}
