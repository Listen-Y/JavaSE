package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-20
 * Time: 11:22
 */
public class Counter {

    private final AtomicInteger atomicInteger;

    public Counter(int val) {
        this.atomicInteger = new AtomicInteger(val);
    }

    private int getCount() {
        return atomicInteger.get();
    }

    private void increase() {
        atomicInteger.getAndIncrement();
    }

    private void set(int newVal) {
        atomicInteger.set(newVal);
    }
}
