package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-30
 * Time: 20:02
 */
public class Solution {

    public int findPath(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (add(nums, i, j) == target && (j - i + 1) > ret) {
                    ret = j - i + 1;
                }
            }
        }
        return ret;
    }

    private int add(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPath(new int[]{1, 3, 4, 3, 9, 1}, 12));
    }
}
