package com.solution;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-24
 * Time: 14:59
 */
public class Solution {


    /**
     * 因为题目路要求最少是俩个正数数字的下标, 所以定初始low为1 high为2,
     * 如果这俩个数据序列相加大于sum 则low++
     * 如果小于sum则high++
     * 如果相等, 记录这个链表
     * 直达这俩个low和high表示的数字相同
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (low < high) {
            int tempSum = ((high - low + 1) * (low + high)) >> 1;
            if (tempSum > sum) {
                low++;
            } else if (tempSum < sum) {
                high++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                high++;
            }
        }
        return result;
    }
}
