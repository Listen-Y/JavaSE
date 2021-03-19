package com.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-20
 * Time: 10:39
 */
public class Atomic {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        integer.getAndSet(1);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A开始");
                countDownLatch.countDown();
                countDownLatch.countDown();
                System.out.println("A结束");
            }
        }).start();

        System.out.println("B等待");
        countDownLatch.await();
        System.out.println("B结束");
    }
}
