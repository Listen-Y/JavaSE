package com.demo.Solution;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int count = scan.nextInt();
            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = scan.nextInt();
            }
            List<String> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            fun(list, "", stack, nums, 0, 0);
            Collections.sort(list);
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    public static void fun(List<String> list, String str, Stack<Integer> stack, int[] nums, int out, int insert) {

        if (out == nums.length) {
            list.add(str.trim());
            return;
        }
        if (insert < nums.length) {
            stack.push(nums[insert]);
            fun(list, str, stack, nums, out, insert + 1);
            stack.pop();
        }

        if (!stack.isEmpty()) {
            int temp = stack.pop();
            fun(list, str + " " + temp, stack, nums, out + 1, insert);
            stack.push(temp);
        }


    }
}