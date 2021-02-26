package com.demo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-10
 * Time: 10:25
 */
public class Demo {

    public static void main1(String[] args) {
        int i = 5;
        int s = (i++) + (++i) + (i--) + (--i);
        System.out.println(s);
    }

    public static void main2(String[] args) {
        List<String> list = new ArrayList<>();
        int[] nums = new int[] {1,2,3};
        fun(list, nums, "");
        Collections.sort(list);
        for (String s : list
             ) {
            System.out.println(s);
        }
    }

    public static void fun(List<String> list, int[] nums, String temp) {
        if (temp.length() == nums.length) {
            list.add(temp);
            return;
        }
        for (int num : nums) {
            if (!temp.contains(String.valueOf(num))) {
                fun(list, nums, temp + num);
            }
        }
    }

    public static void main(String[] args) {
        int[] insert = new int[] {1,2,3,4};
        int[] out = new int[] {4,3,2,1};
        System.out.println(is(insert, out));
    }

    private static boolean is(int[] insert, int[] out) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int value : insert) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == out[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
