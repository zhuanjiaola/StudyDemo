package com.byx.study.mooc;

import java.lang.String;

public class BaseStrengthenTest {

    private char value[];

    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //
        //ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        //
        //ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        //
        //ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //String s = new String();
        //StringBuffer stringBuffer = new StringBuffer();
        //StringBuilder stringBuilder = new StringBuilder();

        String s = "hello";
        System.out.println(s.hashCode());
        s = "world";
        System.out.println(s.hashCode());
        s = "111";
        s = "333";
        System.out.println(s);

        char[] chars = {'1', '2'};
        char[] chars1 = chars;

        final Student student = new Student();
        student.setName("tom");

        Student student1;

        student1 = student;
        System.out.println(student1.getName());
        student1.setName("jean");
        System.out.println(student1.getName());
        System.out.println(student.getName());
        s.replace('3', '4');
        System.out.println(s);


        BaseStrengthenTest baseStrengthenTest = new BaseStrengthenTest(chars, true);


//        final int[] value={1,2,3};
//        int[] another={4,5,6};
//        value=another;
////编译器报错，final不可变

    }
    BaseStrengthenTest(char[] value, boolean share) {
        // assert share : "unshared not supported";
        System.out.println(1111);
    }
}
