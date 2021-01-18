package com.solution;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-10
 * Time: 12:25
 */
public class Test {

    public static void main(String[] args) {
/*        Solution solution = new Solution();
        int[] nums = new int[] {2,2,3};
        List<List<Integer>> lists = solution.allKinds(nums);
        for (List<Integer> l:lists
             ) {
            System.out.println(l);
        }*/
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
        thread.start();
    }
}
