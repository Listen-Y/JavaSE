package com;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        list.add(map);
        map.put("aa", "aaa");
        list.add(map);
        map.put("aaa", "aaaa");
        list.add(map);

        /**
         * stream.map()
         * 表示把数据进行映射， 比如把下面的数据进行映射
         */
        Stream<Object> stream = list.stream().map(n -> n.get("a"));

        /**
         *collect表示数据流的一个收集， 里面可以用Collectors工具类里面的toMap表示把结果集映射成一个map
         * 此时的第一个参数表示k， 第二个参数表示value， 第三个参数表示如果value相同怎么办， 也就是如何解决哈希冲突
         */
        Map<String, String> collect = stream.collect(Collectors.toMap(Object::toString, Object::toString
                , (k1, k2) -> "看"));

        System.out.println(collect);


    }

    public static void fun2(int[] arr) {
        if (arr == null) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                queue.offer(0);
                length--;
            }
            queue.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
    }
}
