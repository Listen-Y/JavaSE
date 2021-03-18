package com.solution;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-19
 * Time: 15:47
 */
public class Solution {


    /**
     * 求数组中的数据组成最小的数字, 我首先使用深度优先对数组进行排列,
     * 然后将排列后的数据每次都进行字符串拼接
     * 拼接后之后和以前的进行比较, ret值记录小的那个数据
     *
     * 注意在排列的时候使用深度优先探索, for循环的起始位置是index
     * 并且如果i!=index && 俩下标数据相同的时候不进行深度探索, 因为排列无效
     */
    private String ret = "";
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return ret;
        }
        dfs(numbers, 0);
        return ret;
    }

    private void dfs(int[] array, int index) {
        if (index == array.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : array) {
                sb.append(num);
            }
            if (ret.equals("")) {
                ret = sb.toString();
            } else if (sb.toString().compareTo(ret) < 0) {
                ret = sb.toString();
            }
            return;
        }
        for (int i = index; i < array.length; i++) {
            if (i != index && array[i] == array[index]) {
                continue;
            }
            swap(array, i, index);
            dfs(array, index + 1);
            swap(array, i, index);
        }
    }

    private void swap(int[] array, int i, int index) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }


    /**
     * 这是第二种思路, 双层暴力循环, 每次将俩个下标的数字进行前后拼接
     * 如果逆序拼接的那个数字小, 那就将俩个下标的数字进行互换
     * @param numbers
     * @return
     */
    public String PrintMinNumber2(int [] numbers) {

        StringBuilder sb = new StringBuilder();
        if (numbers == null ||numbers.length == 0) {
            return sb.toString();
        }
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String one = "" + numbers[i] + numbers[j];
                String two = "" + numbers[j] + numbers[i];
                if (one.compareTo(two) > 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (int num : numbers) {
            sb.append(num);
        }
        return sb.toString();
    }


    /**
     * 正则匹配
     * 递归首先判断正则字符串是否为空, 空则判断str是否为空
     * 然后再判断普通字符是否为空的前提下判断俩个字符串的第一个字符是不是相等的, 相等为true
     * 然后在判断正则的第二个f字符是不是为*
     * 如果为*,则再次分类, 第一个字符不等的话正则直接跳俩个
     * 相等的话进行俩次||的递归, 首页是正则跳俩个, 然后是普通跳一个, 只有要一个满足即可
     *
     * 如果第二个字符不是*, 再次由第一个字符相等不行等进行分类
     * 如果相等 纷纷跳一个进行递归
     * 如果不相等, 直接返回false
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
        return fun(String.valueOf(str), String.valueOf(pattern));
    }

    private boolean fun(String str, String pattern) {
        if(pattern.isEmpty()) {
            return str.isEmpty();
        }
        boolean first = !str.isEmpty()
                && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            if (!first) {
                return fun(str, pattern.substring(2));
            } else {
                return fun(str, pattern.substring(2)) || fun(str.substring(1), pattern);
            }
        } else {
            if (!first) {
                return false;
            } else {
                return fun(str.substring(1), pattern.substring(1));
            }
        }
    }


    /**
     * 相对比较简单
     * 利用链表的特性, 如果没有就插入链表, 如果有就删除, 但是要注意, 删的时候要将char换成Character
     * 不然默认使用的就是index下标的删除
     */
    //Insert one char from stringstream
    private List<Character> list = new LinkedList<>();
    public void Insert(char ch)
    {
        if (list.contains(ch)) {
            list.remove((Character)ch);
        } else {
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return list.isEmpty() ? '#' : list.get(0);
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 找出环中的入口, 首先要使用俩个指针指向头结点, 然后判断快指针不为null并且快指针的下一个不为null
     * 然后快走俩步, 慢走一步, 判断是否相等
     * 退出之后让慢回到头结点, 然后俩个指针一步一步走, 如果有环肯定能在环口相遇
     * 然后返回相遇节点
     *
     * 每循环一次快比慢多走一步, 假设循环3次, 慢快就比慢多走了三步, 那就让慢的再回去, 我们俩个一步一步走, 最终就会在入口相遇
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead;
        ListNode fast = pHead;
        boolean find = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                find = true;
                break;
            }
        }
        if (!find) {
            return null;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 使用这个方式比较耗内存
     * 使用一个set进行无重复存储, 如果存储到一样的节点, 就说明又环, 返回这个环即可
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = pHead;
        while (temp != null) {
            if (!set.contains(temp)) {
                set.add(temp);
            } else {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
