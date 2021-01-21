package com.solution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-17
 * Time: 8:40
 */
public class Solution {

    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n) - 1;
        int[] ans = new int[max];
        for (int i = 1; i <= max; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }


    private char[] nums = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printBigNumbers(int n) {
        StringBuilder builder = new StringBuilder();
        dfs(0, n, builder, new char[n]);
        return builder.toString();
    }

    private void dfs(int temp, int index, StringBuilder builder, char[] chars) {
        if (temp == index) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '0') {
                    for (int j = i; j < chars.length; j++) {
                        str.append(chars[j]);
                    }
                    break;
                }
            }
            if (str.length() != 0) {
                builder.append(str).append(',');
            }
            return;
        }
        for (char num : nums
             ) {
            chars[temp] = num;
            dfs(temp + 1, index, builder, chars);
        }
    }


      static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre.next = head;
            head = head.next;
            pre = pre.next;
        }
        return newHead.next;
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean key = !s.isEmpty() && (s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.';

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (key) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (key) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }

    }

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0;i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.或者e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }

    private int[] ans;
    private int index = 0;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        ans = new int[row * col];
        System.out.println(ans.length);
        fun(matrix, 0, col, row);
        return ans;
    }

    private void fun(int[][] matrix, int start, int col, int row) {
        if (start >= col || start >= row || col < 1 || row < 1) {
            return;
        }
        //打印第一行
        for (int i = start; i < col; i++) {
            ans[index++] = matrix[start][i];
        }
        //打印最后第一列
        for (int i = start + 1; i < row; i++) {
            ans[index++] = matrix[i][col - 1];
        }
        //打印最后一行
        for (int i = col - 1 - 1; (i >= start) && (row > start); i--) {
            ans[index++] = matrix[row - 1][i];
        }
        //打印第一列
        for (int i = row - 1 - 1; (i > start) && (col > start); i--) {
            ans[index++] = matrix[i][start];
        }
        fun(matrix, start + 1, col - 1, row - 1);
    }

}
