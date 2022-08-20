package com.byx.study.thread;


public class VolatileTest {

   static volatile int result;

    public static void main(String[] args) {
        Runnable target = new Computation();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(target).start();
    }

    static class Computation implements Runnable {
        public Computation() {
        }

        public void run() {
            countprint(result);
        }

        public synchronized void countprint(int result) {
            result = result + 2;
            System.out.println(result);
            //System.out.print(result + " ");
        }
    }


}