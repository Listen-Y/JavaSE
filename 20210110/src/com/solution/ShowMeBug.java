package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-10
 * Time: 16:14
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 代码交流
 * 找一段之前写过或者看过的代码，对代码进行讲解
 *
 * 1 说明一下代码的背景和需要完成的职责
 *
 * 2 说明一下代码的构成和主流程
 *
 * 3 评论一下哪些地方写得好，哪些地方需要改进
 *
 * 4 工程设计上的考虑
 */
class Demo {

    /**
     * 代码段1 -->
     * 由饿汉模式下的单例模式改进到懒汉模式下的单例模式
     */
    private static Object object;

    public static Object getObject() {

        if (object == null) {
            synchronized(object) {
                if (object == null) {
                    object = new Object();
                }
            }
        }

        return object;
    }


    /**
     * 代码段2 -->
     * 生产者消费者模型
     */
    private final List<Integer> list = new ArrayList<>();
    private final Object lock = new Object();

    public void producer(int val) throws InterruptedException {

        synchronized (lock) {
            if (list.size() > 0) {
                lock.wait();
            }
            list.add(val);
            lock.notify();
        }
    }

    public int consumer() throws InterruptedException {

        int ret = -1;
        synchronized (lock) {
            if (list.size() == 0) {
                lock.wait();
            }
            ret = list.get(0);
            lock.notify();
        }
        return ret;
    }


    /**
     * 代码段3 -->
     * 循环打印 体现ReentrantLock的优秀之处
     */
    private final Lock reentrantLock = new ReentrantLock();
    private Condition conditionA = reentrantLock.newCondition();
    private Condition conditionB = reentrantLock.newCondition();
    private Condition conditionC = reentrantLock.newCondition();
    private volatile int key = 1;


    public void printA() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (key != 1) {
                conditionA.await();
            }
            System.out.println("A");
            key = 2;
            conditionB.notify();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (key != 2) {
                conditionB.await();
            }
            System.out.println("B");
            key = 3;
            conditionC.notify();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (key != 3) {
                conditionC.await();
            }
            System.out.println("C");
            key = 1;
            conditionA.notify();
        } finally {
            reentrantLock.unlock();
        }
    }


    /**
     * 代码段4 -->
     * 线程池
     * 对JDK源码的优化
     */
    public void JDKThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        /**
         *     public static ExecutorService newFixedThreadPool(int nThreads) {
         *         return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *     }
         *
         *
         *         public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler)
         *
         *
         *
         *      public void execute(Runnable command) {
         *         if (command == null)
         *             throw new NullPointerException();
         *         int c = ctl.get();
         *         if (workerCountOf(c) < corePoolSize) {
         *              if (addWorker(command, true))
         *                   return;
         *              c = ctl.get();
         *         }
         *         if (isRunning(c) && workQueue.offer(command)) {
         *                  int recheck = ctl.get();
         *         } else if (!addWorker(command, false))
         *         reject(command);
         *     }
         *
         *
         *
         *
         *
         *    public LinkedBlockingQueue() {
         *         this(Integer.MAX_VALUE);
         *     }
         *
         */

        new ThreadPoolExecutor(3,
                5,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

    }
}


public class ShowMeBug {

    public static void main(String[] args) {

    }
}

