package com.sort;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-06
 * Time: 14:44
 */
public class Sort {

    public int[] findMax(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        return nums;
    }

    /**
     * 验证IP地址的合法性
     */
    public static boolean isIP(String ip) {
        if (ip == null) {
            return false;
        }
        String[] parts = ip.split("\\.");
        //ipv4是4个部分
        if (parts.length == 4) {
            //判断每个部分是否合法
            for (String part : parts) {
                //判断是否有非数字
                for (int j = 0; j < part.length(); j++) {
                    char ch = part.charAt(j);
                    if (ch < '0' || ch > '9') {
                        return false;
                    }
                }
                //判断每部分是否是在0~255
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"192.168.0.1", "0.0.0.0", "192.256.0.1",
                "192.-1.0.1", "192.168.0a.1", "192.168.3.2.3"};
        for (String s : strings
             ) {
            System.out.println(isIP(s));
        }
    }

    public void bubbling(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 复习堆排序
     * @param array
     */
    public void heap(int[] array) {
        createHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            shiftDown(array, 0, i);
        }
    }

    private void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, i, array.length);
        }
    }

    private void shiftDown(int[] array, int index, int size) {
        int parent = index;
        int child = (2 * parent) + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child++;
            }
            if (array[parent] < array[child]) {
                int temp = array[parent];
                array[parent] = array[child];
                array[child] = temp;
            } else {
                break;
            }
            parent = child;
            child = (2 * parent) + 1;
        }
    }


}
