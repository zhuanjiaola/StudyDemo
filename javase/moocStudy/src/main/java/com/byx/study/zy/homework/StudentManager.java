package com.byx.study.zy.homework;

import java.util.Set;
import java.util.TreeSet;

public class StudentManager {
    //请补充代码
    //定义一个TreeSet对象
    Set<Student> studentSet = new TreeSet<>(new MyComparator());

    //定义方法：void add(Student st)
    public void add(Student st) {
        studentSet.add(st);
    }

    //定义方法：void output()
    public void output() {
        studentSet.forEach(System.out::println);
    }

    //定义方法：double average()
    public double average() {
        double sum = 0;
        for (Student student : studentSet) {
            sum += student.getScore();
        }
        return sum / studentSet.size();
    }

}
