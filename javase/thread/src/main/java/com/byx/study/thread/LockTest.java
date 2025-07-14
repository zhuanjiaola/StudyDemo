/**
 * LY.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package com.byx.study.thread;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhenxing.wang
 * @version Id: LockTest, v 0.1 2025/6/25 14:29 1205869 Exp $
 */
public class LockTest {


    public static void main(String[] args) throws InterruptedException, IOException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            System.out.println("子线程获取锁资源并await挂起线程");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                condition1.await();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程挂起后被唤醒!持有锁资源");
        }).start();
        Thread.sleep(100);
        // =================main======================
        lock.lock();
        System.out.println("主线程等待5s拿到锁资源，子线程执行了await方法");
        condition1.signal();
        System.out.println("主线程唤醒了await挂起的子线程");
        lock.unlock();
    }

}
