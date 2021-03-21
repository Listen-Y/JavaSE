package com.demo;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-21
 * Time: 11:35
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        String s  = "listen";
        List<Person> list = new ArrayList<>();
        list.clear();

        Person person = new Person(20);
        //软引用
        SoftReference<Person> soft = new SoftReference<>(person);

        Person person1 = new Person(23);
        //弱引用
        WeakReference<Person> week = new WeakReference<>(person1);

        //通知GC
        System.gc();
        Thread.sleep(1000);
        if (soft.get() == null) {
            System.out.println("person: 软引用已经死亡");
        } else {
            System.out.println("person: 软引用还活着");
            System.out.println(soft.get());
        }
        if (week.get() == null) {
            System.out.println("person1: 弱引用已经死亡");
        } else {
            System.out.println("person1: 弱引用还活着");
            System.out.println(soft.get());
        }

        Person obj = new Person(12);
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(obj,refQueue);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Reference reference = refQueue.poll();
                    if (reference == null) {
                        System.out.println("phantomReference:" + "被回收");
                        break;
                    } else {
                        System.out.println("还活着");
                    }
                }
            }
        }).start();
    }
}

class Person {
    String name = "aaa";
    int age = 14;


    public Person(int age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


}
