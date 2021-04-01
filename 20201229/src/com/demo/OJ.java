package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-29
 * Time: 16:07
 */
public class OJ {

    public static void main(String[] args) {

        /**
         * 构建死锁的产生
         */
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("...");
                    }
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("...");
                    }
                }
            }
        }).start();
        thread.start();


    }
}
