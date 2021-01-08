package com.sort;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-06
 * Time: 14:57
 */
public class Demo {

    public synchronized static void play() {
        System.out.println("play");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void play2() {
        System.out.println("play2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main2(String[] args) {
/*        HashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put(null, null);
        System.out.println(hashMap.get(null));
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();*/

        Demo demo = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.play();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.play();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Demo.play();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.play2();
            }
        }).start();

    }

    public static void main(String[] args) throws Exception {
/*        Sort sort = new Sort();
        int[] array = new int[] {9,8,7,6,5,4,3,2,1};
        sort.heap(array);
        System.out.println(Arrays.toString(array));*/

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
