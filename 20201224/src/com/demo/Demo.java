package com.demo;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-24
 * Time: 10:44
 */
public class Demo {

    public static void main(String[] args) {
        HashMap<String ,String> map = new HashMap<>();
        map.put("aaa", "aaa");
        int i = 0;
        while (i < 100) {
            System.out.println(i & 15);
            i++;
        }

        Vector<Demo> vector = new Vector<>();
        ConcurrentSkipListMap<String, String> map1 = new ConcurrentSkipListMap<>();
        map1.put();

        ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
        map2.put();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

    }
}
