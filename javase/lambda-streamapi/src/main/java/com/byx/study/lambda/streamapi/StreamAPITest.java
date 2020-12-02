package com.byx.study.lambda.streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author wang zhen xing
 * @date 2020/12/2 15:31
 */
public class StreamAPITest {

    public static List<FruitSale> list;

    static {
        list = Arrays.asList(
                new FruitSale("苹果", 2.8, 6.6, 12345, 11),
                new FruitSale("石榴", 3.1, 6.8, 775, 11),
                new FruitSale("苹果", 2.7, 6.6, 10999, 10),
                new FruitSale("橙子", 1.6, null, null, null)
        );
    }

    @Test
    public void test01() {
        // 逆序排序
        list.sort((f1, f2) -> Double.compare(f2.getPurchasingPrice(), f1.getPurchasingPrice()));
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        List<FruitSale> list = StreamAPITest.list.stream().filter(f -> f.getPurchasingPrice() > 3).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void test03() {
        List<FruitSale> list = StreamAPITest.list.stream().filter(x -> x.getName() != null && x.getName().equals("苹果")).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void test04() {
        FruitSale fruitSale = list.stream().filter(x -> x.getSellingPrice() != null).max(Comparator.comparingDouble(FruitSale::getSellingPrice)).get();
        System.out.println(fruitSale);
    }

    @Test
    public void test05() {
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        list.stream().filter(x -> x.getMonth() != null && x.getMonth() == 11).forEach(f -> total.updateAndGet(v -> v + (f.getSellingPrice() - f.getPurchasingPrice()) * f.getSalesVolume()));
        System.out.println(total.get());
    }

}

@Data
@AllArgsConstructor
class FruitSale {
    private String name;
    private Double purchasingPrice;
    private Double sellingPrice;
    private Integer salesVolume;
    private Integer month;
}