package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-29
 * Time: 16:13
 */
public class ReadWriteLock {

    private int mutex = 1;

    synchronized public void write() {
        mutex--;
        System.out.println("write");
        mutex++;
    }

    public void read() {
        if (mutex != 1) {
            return;
        }
        System.out.println("read");
    }

}
