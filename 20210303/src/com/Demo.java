package com;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo extends One {

    public void main1(String[] args) {
        /**
         * volatile如果修饰的是对象或者数组， 可见行只是对这个对象的地址可见， 对其内部的成员是不保证可见性的
         * 这也是为什么ConcurrentHashMap中的table数组是volatile修饰的， 而且node中的key和value都是被
         * volatile修饰的
         */
        Map<String, String> map = new ConcurrentHashMap<>();
    }

    @Override
    void one() {

    }


    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    store.A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    store.B();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    store.C();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
    }

}

abstract class One {
    abstract void one();
}

class Store {

    private volatile int ticket = 1;

    /**
     * A售票口
     * @throws InterruptedException
     */
    public void A() throws InterruptedException {

        int temp;
        while ((temp = getSetTicket()) != -1) {
            System.out.println(temp + " A");
            Thread.sleep(100);
        }
    }

    /**
     * B售票口
     * @throws InterruptedException
     */
    public void B() throws InterruptedException {

        int temp;
        while ((temp = getSetTicket()) != -1) {
            System.out.println(temp + " B");
            Thread.sleep(100);
        }
    }

    /**
     * 售票口
     * @throws InterruptedException
     */
    public void C() throws InterruptedException {

        int temp;
        while ((temp = getSetTicket()) != -1) {
            System.out.println(temp + " C");
            Thread.sleep(100);
        }
    }

    /**
     * 查看票和取票的同步操作
     * @return
     */
    public synchronized int getSetTicket() {
        int temp = this.ticket;

        //查看此时票是否能卖出
        if (temp > 100) {
            return -1;
        }

        //取票
        this.ticket++;
        return temp;
    }
}


