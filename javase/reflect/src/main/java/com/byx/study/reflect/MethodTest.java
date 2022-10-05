package com.byx.study.reflect;

import java.lang.reflect.Method;

/**
 * @author 1205869
 * @version Id: MethodTest, v 0.1 2022/10/5 18:05 1205869 Exp $
 */
public class MethodTest {

    public static void main(String[] args) throws Exception {
        Class<A> clazz = A.class;
        A a = clazz.newInstance();

        Method method = clazz.getMethod("print", String.class);

        for (int i = 0; i < 5; i++) {
            Object invoke = method.invoke(a, Integer.toString(i));
            System.out.println("invoke: "+invoke);
        }

    }

}

class A {
    public String print(String s) {
        System.out.println(s);
        return s + ";";
    }

}
