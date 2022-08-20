package com.byx.study.zy.homework;

import java.util.*;

public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return Double.compare(s1.getScore(), s2.getScore());
        }

        Map<String, String> map = new HashMap<>();

        List<String> list = new ArrayList<>();

        Set<String> set = new HashSet<>();

        return 0;
    }
}
