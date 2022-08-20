package com.byx.study.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 3个线程从0到100轮流打印。要求输出结果如下
 * Thread-0:0
 * Thread-1:1
 * Thread-2:2
 * Thread-0:3
 * <p>
 * 知识点扫盲：
 * 1. 类锁的wait、notify
 * 2. lambda内部使用局部变量会隐式加final，可以使用成员变量（为了避免外部线程修改了并回收了局部变量，内部仍要访问的问题。实现上是一个副本）
 * <p>
 *
 * @author QuCheng on 2020/4/10.
 */
public class MultiThread {

    public static int n = 0;

    public static final MultiThread m = new MultiThread();

    int state = 0;


    /**
     * 常规思路：加锁 -> 不满足条件wait -> 满足条件执行并notifyAll
     */
    private Runnable sync1() {
        return () -> {
            int nameI = Integer.parseInt(Thread.currentThread().getName());
            while (n <= 100) {
                synchronized (MultiThread.class) {
                    if (n % 3 == nameI && n <= 100) {
                        System.out.println("Thread-" + nameI + ": " + n++);
                        MultiThread.class.notifyAll();
                    } else {
                        try {
                            MultiThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    /**
     * 省掉不必要的wait()，notifyAll()
     */
    private Runnable sync2() {
        return () -> {
            int nameI = Integer.parseInt(Thread.currentThread().getName());
            while (n <= 100) {
                synchronized (MultiThread.class) {
                    //System.out.println("Thread-" + nameI);

                    if (n % 3 == nameI && n <= 100) {
                        System.out.println("Thread-" + nameI + ": " + n++);
                    }
                }
            }
        };
    }

    /**
     * 不显示加锁 - 问题所在？此处难道是锁粗化，那为什么把n++放在打印里面又出问题
     */
    public Runnable sync3() {
        return () -> {
            int nameI = Integer.parseInt(Thread.currentThread().getName());
            while (n <= 1000) {
                if (n % 3 == nameI) {
                    System.out.println("Thread-" + nameI + ": " + n);
                    n++;
                }
            }
        };
    }

    public Runnable sync4(int curState, int nextState) {
        return () -> {
            while (n <= 100) {
                synchronized (m) {
                    while (state != curState) {
                        try {
                            m.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //for (int j = 0; j < 5; j++) {
                    //    System.out.println(Thread.currentThread().getName() + ": " + n++);
                    //}
                    if (n <= 100) {
                        System.out.println(Thread.currentThread().getName() + ": " + n++);
                    }
                    state = nextState;
                    m.notifyAll();
                }
            }

        };


    }


    public static void main(String[] args) {

        MultiThread z = new MultiThread();
        //Runnable r = z.sync1();
        Runnable r = z.sync2();
        //Runnable r = z.sync3();

        new Thread(r, "0").start();
        new Thread(r, "1").start();
        new Thread(r, "2").start();

        //new Thread(z.sync4(0, 1), "线程1").start();
        //new Thread(z.sync4(1, 2), "线程2").start();
        //new Thread(z.sync4(2, 0), "线程3").start();

    }
}