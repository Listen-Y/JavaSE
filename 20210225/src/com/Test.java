package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main1(String[] args) {
        People people = new People();
        people.check();
    }

    public static List<String> getL(List<String>... args) {
        args[0].add("bbb");
        return args.length > 0 ? args[0]: null;
    }




    public static void main2(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        System.out.println(getL(list));
    }

    @SafeVarargs
    public static <T> List<T> asList(T... a){
        return null;
    }

    public static void main3(String[] args) {
        List<String> list = asList("a", "a");
        String s = list.get(0);

    }


    // 这其实不是一个安全的类型检查
    @SafeVarargs
    static void m(List<String>...lists){
        // 先会存储到 array[0] 的位置
        Object[] array = lists;
        List<Integer> tmpList = Arrays.asList(42);
        // array[0] 又保存了tmpList(Integer)进行覆盖
        // tmpList是一个List对象（类型已经擦除），赋值给Object类型的对象是允许的（向上转型），
        // 能够编译通过
        array[0] = tmpList;
        // 实际取出来的应该是 42
        String s = lists[0].get(0);

    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("one","two");
        m(list1);
    }



}
