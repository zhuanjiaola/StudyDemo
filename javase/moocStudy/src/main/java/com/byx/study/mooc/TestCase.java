package com.byx.study.mooc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCase {

    public static void main(String[] args) {

        int[] s = {1, 2, 5, 9, 12};

        int i = Arrays.binarySearch(s, 9);
        System.out.println(s[Arrays.binarySearch(s, 12)]);

        //Collections.binarySearch()

        List<String> list = new ArrayList<>();
        list.add("222");

        list = Collections.unmodifiableList(list);

        //list.add("11");
        System.out.println(list);
        System.out.println(list.size());


    }

    @Test
    public void test01() {
        System.out.println(print());

    }

    public int print() {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            return 0;
        } finally {
            System.out.println("finally");
            return 2;
        }
    }

}
