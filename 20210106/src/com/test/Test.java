package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-06
 * Time: 19:58
 */
public class Test {

    public int findMaxLength(String s) {
        List<Character> list = new ArrayList<>();
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))) {
                    list.add(s.charAt(i));
                } else {
                    ret = Math.max(ret, list.size());
                }
            }
            list.clear();
        }
        return ret;
    }

    public void zero(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = nums.length - 1; j > i; j--) {
                    nums[j] = nums[j - 1];
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        int[][] nums = new int[][] {{0, 0, 0, 0, 0, 0},
                {1, 2, 3, 4, 5, 6},
                {0, 1, 2, 3, 0, 4},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 0}};
/*        {0, 0, 0, 0, 0, 0},
        {1, 2, 3, 4, 5, 6},
        {0, 1, 2, 3, 0, 4},
        {1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 1, 0},*/

        for (int[] num: nums
             ) {
            test.zero(num);
            System.out.println(Arrays.toString(num));
        }

    }
}
