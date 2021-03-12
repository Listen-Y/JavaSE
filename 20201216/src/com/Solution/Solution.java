package com.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-16
 * Time: 14:50
 */
public class Solution {

    /**
     * 不使用乘除实现累加, 使用 || 或者 && 实现, 在使用&&的时候,只要前一个为假后面的就不会判断
     * 使用||的时候, 只要前一个为真后面就不会判断
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n == 0) || ((sum += Sum_Solution(n - 1)) > 0);
        /*boolean b = (n != 0) && ((sum += Sum_Solution(n - 1)) > 0);*/

        return sum;
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 求二叉树深度, 首先看其根节点, 为null返回0,否则返回其左节点和右节点的最大深度然后加一
     * 加一表示加上此层的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        depth = 1;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + depth;
    }


    /**
     * 判断是不是平衡二叉树, 如果是空树返回true
     * 然后求该节点的左子树最大深度和右子树最大深度, 如果大一1返回false
     * 如果不大于一在递归看其左子树和右子树是不是平衡二叉树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    /**
     * 寻找数组中只出现一次的俩个数字,使用map进行统计即可, 然后使用entrySet遍历即可
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array
             ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        boolean key = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
             ) {
            if (key && entry.getValue() == 1) {
                num1[0] = entry.getKey();
                key = false;
            } else if (entry.getValue() == 1) {
                num2[0] = entry.getKey();
            }
        }
    }


    /**
     * 第二种解法就是先将所有元素进行 ^
     * 然后将 ^ 的结果和自己的负数进行 &
     * 最后再次遍历数组, 和上面的数据结果进行 &
     * 如果为0 就与结果1中的数据进行 ^
     * 结果为1就放到结果2 中
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        temp &= -temp;
        for (int val : array) {
            if ((val & temp) == 0) {
                num1[0] ^= val;
            } else {
                num2[0] ^= val;
            }
        }
    }


    /**
     * 将字符串变换成数字, 首先判断第一位是+和- , 表示正数和负数, 没有默认为正数
     * 然后对其进行分割判断, 取其每一位数据, 然后让其乘以相应10的次方, 然后相加即可
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ret = 1;
        if (str.charAt(0) == '+') {
            ret = fun(str.substring(1, str.length()));
        } else if (str.charAt(0) == '-') {
            ret = -1 * fun(str.substring(1, str.length()));
        } else {
            ret = fun(str);
        }
        return ret;
    }

    private int fun(String str) {
        int ret = 0;
        int len = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i) - '0';
            if (temp > 9 || temp < 0) {
                return 0;
            }
            ret += temp * Math.pow(10, len);
            len--;
        }
        return ret;
    }


    /**
     * 这是第二种做法, 一个for循环, 如果第一个字符为符号 + - 就跳过
     * 设置一个num 为0 , 那在后面数字的拼接上直接num * 10 + 数字即可
     * @param str
     * @return
     */
    public int StrToInt2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0 ;i < str.length(); i++) {
            if(str.charAt(0) == '+' || str.charAt(i) == '-') {
                continue;
            }
            int temp = str.charAt(i) - '0';
            if (temp < 0 || temp > 9) {
                return 0;
            }
            num = num * 10 + temp;
        }
        return str.charAt(0) == '-' ? -num : num;
    }


    /**
     * q求出现次数超过数组长度一般的数组, 我使用的是map统计
     * 注意使用getOrDefault第一个参数是key值, 第二个是默认value值
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
/*            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }*/
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (array.length / 2)) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
