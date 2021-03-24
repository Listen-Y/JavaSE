package com.solution;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-24
 * Time: 15:18
 */
public class Test {

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> lists = s.FindContinuousSequence(9);
        System.out.println(lists);
    }
}
