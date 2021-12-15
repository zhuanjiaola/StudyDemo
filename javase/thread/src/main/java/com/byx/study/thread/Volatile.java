package com.byx.study.thread;

import org.junit.Test;

public class Volatile {

    volatile String s = "hello";

    @Test
    public void run() {
        System.out.println(s);
    }

}
