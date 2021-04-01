package com.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-29
 * Time: 16:30
 */
public class CAS {


    private volatile int times = 2;
    private final AtomicInteger num = new AtomicInteger(0);

    public void A() {

        while (times > 0) {
            while (num.get() == 0) {
                int count = 0;
                while (count < 3) {
                    System.out.println("A");
                    count++;
                }
                num.set(1);
            }

        }

    }

    public void B() {
        while (times > 0) {
            while (num.get() == 1) {
                int count = 0;
                while (count < 2) {
                    System.out.println("B");
                    count++;
                }
                num.set(2);
            }

        }
    }

    public void C() {
        while (times > 0) {
            while (num.get() == 2) {
                int count = 0;
                while (count < 1) {
                    System.out.println("C");
                    count++;
                }
                if (times > 0) {
                    times--;
                    num.set(0);
                }
            }

        }
    }

    public static void main(String[] args) {
        CAS cas = new CAS();
        new Thread(() -> {

                cas.A();

        }, "A").start();
        new Thread(() -> {

                cas.B();

        }, "B").start();
        new Thread(() -> {

                cas.C();

        }, "C").start();
    }
}
