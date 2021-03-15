package com.solution;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-17
 * Time: 19:41
 */
public class Solution {

    public static void main(String[] args) {

    }


    /**
     * 求字符串的排列组合, 可以有重复字符
     * 使用深度优先探索, dfs中的for循环应该 i=index开始往后走, 如果下标相同还是往后走,
     * 下标不同的话看这俩个下标的字符是否相同, 如果相同没必要往深走, 符合条件之后交换字符, 往深走
     * 如果深度够了arr的length, 完成 回退
     * 回退之后恢复之前的交换操作, 进行下一次的for循环往深走
     *
     * 从某种意义上来说他的交换是从后往前交换的, 先交换的最后两个字符, 最后交换的是第一个字符和最后一个字符
     * 所以, 在回退之后需要恢复操作
     */
    private final ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return ret;
        }
        char[] arr = str.toCharArray();
        dfs(arr, 0);
        Collections.sort(ret);
        return ret;
    }

    private void dfs(char[] arr, int index) {
        if (index == arr.length) {
            ret.add(String.valueOf(arr));
        }
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[index]) {
                //最开始i== index 继续往深处递归, 回退之后如果俩下标字符相等, 就没必要再往下走
                continue;
            }
            swap(arr, index, i);
            dfs(arr, index + 1);
            //恢复
            swap(arr, index, i);
        }
    }

    private void swap(char[] arr, int index, int i) {
        char temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }


    private ArrayList<String> list;
    public ArrayList<String> Permutation2(String str) {
        list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] arr = str.toCharArray();
        fun(arr, 0);
        Collections.sort(list);
        return list;
    }

    private void fun(char[] arr, int index) {
        if (index == arr.length) {
            list.add(String.valueOf(arr));
        }
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[index]) {
                continue;
            }
            swap(arr, i, index);
            fun(arr, index + 1);
            swap(arr, i, index);
        }
    }

    /**
     * 这道题找规律从2开始观察, 只有2和3比较特殊,
     * 其余分为俩类, 一个是只有3 那就直接3的个数次方即可
     * 其余都是能有减去2之后,也就是减去一个长度为2之后,
     * 还要考虑, 减去2之后是不是还有%3的余数, 如果有后面也要乘进来
     * 能有3就要3, 然后想乘,
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        int a = 0;
        int b = 0;
        int ret = 2;
        if (target == 2) {
            return target;
        }
        if (target == 3) {
            return 2;
        }
        if (target % 3 == 0) {
            return (int) Math.pow(3, target / 3);
        } else {
            a = target - 2;
            b = a % 3;
            ret = ret * (int) Math.pow(3, a / 3);
            if (b != 0) {
                ret *= b;
            }
            return ret;
        }
    }

    /**
     * 一样道理, 二和三额外处理, 其余分俩类
     * 一类是3的倍数, 直接次方即可
     * 一类不是3的倍数, 那就只能是4, 5, 7, 8, 10, 11, 13这些数字
     * 你会发现这些数字减去2为第一段之后, 再次去看此时长度 /3的个数的立方和, 与之前的第一段2相乘
     * 然后还有可能减去2之后 /3 的时候还会有余数, 那么久需要把余数通过%3记录下来, 后面再给乘上去
     * @param target
     * @return
     */
    public int cutRope2(int target) {
        if (target == 2 || target == 3) {
            return 2;
        }
        if (target % 3 == 0) {
            return (int) Math.pow(3, target / 3);
        } else {
            int max = 2;
            int left = target - 2;
            int right = left % 3;
            max = max * (int) Math.pow(3, left / 3);
            if (right != 0) {
                max *= right;
            }
            return max;
        }
    }
}
