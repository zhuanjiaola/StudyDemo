package com.byx.study.zy.homework;

public class StudentTest {
    //添加2个学生信息，计算平均成绩并输出所有学生信息。
    public static void main(String[] args) {
        Student st1=new Student();
        st1.setName("张三");
        st1.setScore(89);
        Student st2=new Student();
        st2.setName("李四");
        st2.setScore(95);

        StudentManager sm=new StudentManager();
        sm.add(st1);
        sm.add(st2);//添加学生
        System.out.println("平均分为:"+sm.average());//计算平均分并输出
        sm.output();//输出所有学生信息
    }
}
