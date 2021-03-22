package com.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-22
 * Time: 13:26
 */
public class Demo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Queue<String> queue = new LinkedList<>();
        //poll和remove其实在源码删除的时候调用的是同一个方法， 没有区别， 但是在异常处理有区别
        //当没有数据的时候poll返回的null remove返回的是异常
        queue.offer("aaa");
        queue.poll();
        System.out.println(queue.remove());

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        cyclicBarrier.await();
        cyclicBarrier.await();
    }
}
