package com.solution;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 20:38
 */
public class Solution {

    /**
     *这道题完全是在考数学, 只能背吧
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int high = n / (i * 10);
            int low = n % i;
            int cur = (n / i) % 10;
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                count += high * i + (low + 1);
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }


    /**
     * 这个就很简单了, 没啥写的必要, 主要使用双指针就行
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0) {
            return list;
        }
        if(size > num.length) {
            return list;
        }
        int start = 0;
        int end = size - 1;
        for (; end < num.length; end++, start++) {
            int temp = num[start];
            for (int i = start + 1; i <= end; i++) {
                if (num[i] > temp) {
                    temp = num[i];
                }
            }
            list.add(temp);
        }
        return list;
    }
}
