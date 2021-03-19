package com.solution;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-20
 * Time: 20:32
 */
public class Solution {


    /**
     * 返回对应下标的丑数, 丑数是1和质数只有2 3 5的数
     * 首先构建index下标个数组, 构建三个下标t2 t3 t5
     * 第一个为1, 然后对这个1进行相乘取最小, 对三个小标分别乘2 3 5 然后取最小
     * 如果这个数是那三个下标的对应2 3 5的倍数, 所以那三个下标就进行++操作 知道index个数据都获得
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] nums = new int[index];
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        nums[0] = 1;
        for (int i = 1; i < index; i++) {
            nums[i] = Math.min(Math.min(nums[t2] * 2, nums[t3]*3), nums[t5] * 5);
            if (nums[i] == nums[t2] * 2) {
                t2++;
            }
            if (nums[i] == nums[t3] * 3) {
                t3++;
            }
            if (nums[i] == nums[t5] * 5) {
                t5++;
            }
        }
        return nums[index - 1];
    }


    static class Node {
        char val;
        int index;

        public Node(char val, int index) {
            this.val = val;
            this.index = index;
        }

        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            if (o instanceof Node) {
                return ((Node) o).val == this.val;
            }
            return false;
        }
    }

    /**
     * 返回第一个出现一次的字符的下标
     * 这道题把每次第一次出现的都正常记录下标, 但是后序如果有此节点就将下标设置为-1
     * 返回结果的时候就判断第一个node数据下标是不是-1 如果是就返回, 如果不是就返回-1
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) {
            return -1;
        }
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            Node node = new Node(str.charAt(i), i);
            if (list.contains(node)) {
                list.remove(node);
                node.index = -1;
            }
            list.add(node);
        }
        for (Node node : list) {
            if (node.index != -1) {
                return node.index;
            }
        }
        return -1;
    }


    /**
     * 这个解法就很牛皮了, 使用基数统计的思想, 对每一个字符的数值的对应下标进行++操作
     * 遍历所有字符进行统计
     * 然后在遍历字符, 查看刚刚完成统计的数组中对应字符下标那个统计结果为1
     * 为1 的话就说明出现了一次, 就返回此时遍历字符串的对应下标
     * 没有的话就返回-1
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] count = new int['z' - 'A' + 1];
        char[] chars = str.toCharArray();
        for (char ch: chars) {
            count[ch - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[chars[i] - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
