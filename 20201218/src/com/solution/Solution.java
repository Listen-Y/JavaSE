package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 9:43
 */
public class Solution {


    /**
     * 以每个下标开始,往后递归累加求和, 每次求和完成都要进行最大值判断,
     * 负数不可以跳过, 以防全是负数的例子
     * 注意最开始默认最大和应该是负数, 还是防止全是负数的例子
     */
    private int ret = 0;
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null ||array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        ret = array[0];
        for (int i = 0; i < array.length; i++) {

            dfs(array, array[i], i + 1);
        }
        return ret;
    }

    private void dfs(int[] array, int sum, int index) {
        if (sum > ret) {
            ret = sum;
        }
        if (index >= array.length) {
            return;
        }
        dfs(array, sum + array[index], index + 1);
    }


    /**
     * 从第二个坐标数字开始, 如果前一个坐标的数字大于0则加上, 小于0则不加
     * 在判断当前下标的数字和记录下的最大和哪个大, 记录大的那个
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null ||array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            sum = Math.max(sum, array[i]);
        }
        return sum;
    }
}
