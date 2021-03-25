package com.solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-25
 * Time: 19:42
 */
public class Solution {

    /**
     * 获得相加的数为sum, 并且乘积最小的
     * 暴力循环, 找答案, 可以的初始为最大值, 以防万一, 还有如果最后ret1和ret2都是0, 说明灭有找到
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int key = Integer.MAX_VALUE;
        int ret1 = 0;
        int ret2 = 0;
        ArrayList<Integer> list = new ArrayList<>(2);
        if (array == null || array.length == 0) {
            return list;
        }
        for (int i = 0; i< array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    if (array[i] * array[j] < key) {
                        ret1 = array[i];
                        ret2 = array[j];
                        key = array[i] * array[j];
                    }
                }
            }
        }
        if (ret1 != 0 && ret2 != 0) {
            list.add(ret1);
            list.add(ret2);
        }
        return list;
    }


    /**
     * 取第一个数和最后一个数, 求和, 如果大于sum, low++
     * 如果小于sum high++
     * 如果相等, 直接放进list返回, 因为数字在最俩边的乘积肯定小
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>(2);
        if (array == null || array.length == 0) {
            return list;
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int temp = array[low] + array[high];
            if (temp == sum) {
                list.add(array[low]);
                list.add(array[high]);
                return list;
            } else if (temp < sum) {
                low++;
            } else {
                high--;
            }
        }
        return list;
    }


    /**
     * 左移位置, 如果大于字符串长度就取余
     * 其次就是将前n个字符放置在后length - n个字符后面
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (n > str.length()) {
            n %= n;
        }
        return str.substring(n) + str.substring(0, n);
    }

    /**
     * 这道题很简单, 就是将字符串用" "分割, 然后遍历长度的一半进行与后面的互换
     * 注意最后一个" "的省去
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strs = str.split(" ");
        int len = strs.length;
        if (len == 0) {
            return str;
        }
        for (int i = 0; i < (len >> 1); i++) {
            String temp = strs[i];
            strs[i] = strs[len - 1 - i];
            strs[strs.length - 1 - i] = temp;
        }
        StringBuilder builder = new StringBuilder();
        for (String temp : strs) {
            builder.append(temp).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 判断是否是顺子
     * 首先对数组进行排序, 然后遍历一遍数组, 如果是0就统计, 因为其可以成为任何数的代替者
     * 第一次就将last记录下, 对于下一个数就看起是不是==last++
     * 如果相等, 记录last 再往后遍历, 如果不等, 就看0的个数, 如果没有就返回false 如果有就代替
     * 让last++ i-- zero--
     * 最后如果遍历完了, 就返回true
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int zero = 0;
        int last = 0;
        Arrays.sort(numbers);
        for (int i = 0; i< numbers.length; i++) {
            if (numbers[i] == 0) {
                zero++;
            } else {
                if (last == 0) {
                    last = numbers[i];
                } else {
                    if (last + 1 == numbers[i]) {
                        last++;
                    } else {
                        if (zero > 0) {
                            zero--;
                            last++;
                            i--;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
