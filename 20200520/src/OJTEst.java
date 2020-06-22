//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }
}

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转
class Solution1 {
    public String reverseOnlyLetters(String S) {
        char[] ret = S.toCharArray();
        int left = 0;
        int right = ret.length - 1;
        while (left < right) {
            while (left < right && !((ret[left] >= 65 && ret[left] <= 90) || ret[left] >= 97 && ret[left] <= 122)) {
                left++;
            }
            while (left < right && !((ret[right] >= 65 && ret[right] <= 90) || ret[right] >= 97 && ret[right] <= 122)) {
                right--;
            }
            if (left < right) {
                char tmp = ret[left];
                ret[left] = ret[right];
                ret[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(ret);
    }
}

public class OJTEst {
}
