package com.solution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-15
 * Time: 20:10
 */
public class Solution {

      static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    public int[] reversePrint(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }
        StringBuilder builder1 = builder.reverse();
        int[] nums = new int[builder.length()];
        Arrays.fill(nums, builder1.length());
        return nums;
    }

    /**
     * 遍历俩遍， 实现链表反转输出
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int[] nums = new int[count];
        while (--count >= 0) {
            nums[count] = head.val;
            head = head.next;
        }
        return nums;
    }

    /**
     * 重建二叉树
     * 每次返回其父亲节点的位置和或左或右节点位置
     * 如果left 》= right 说明不符合条件返回
     */
/*    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (index >= preorder.length) {
            return null;
        }
        if (left >= right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        int pos = findPos(inorder, node.val);
        node.left = buildTreeHelper(preorder, inorder, left, pos);
        node.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return node;
    }*/

    private int findPos(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private int[][] next = new int[][] {{1,0}, {-1,0}, {0,1}, {0, -1}};
    private boolean ret = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isUsed = new boolean[board.length][board[0].length];
                dfs(isUsed, board, i, j, "" + board[i][j], word, 0);
                if (ret) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(boolean[][] isUsed, char[][] board, int row, int col, String temp, String word, int index) {
        if (temp.charAt(index) != word.charAt(index)) {
            return;
        }
        if (temp.equals(word)) {
            ret = true;
            return;
        }
        isUsed[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + next[i][0];
            int newCol = col + next[i][1];

            if (newRow < 0 || newRow == board.length || newCol < 0 || newCol == board[0].length) continue;
            if (isUsed[newRow][newCol]) continue;

            dfs(isUsed, board, newRow, newCol, temp + board[newRow][newCol], word, index + 1);
            if (ret) {
                return;
            }
        }
    }

    public int movingCount(int m, int n, int k) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (fun(i, j, k)) {
                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean fun(int num1, int num2, int k) {
        int temp = 0;
        while (num1 > 0 || num2 > 0) {
            temp += num1 % 10;
            temp += num2 % 10;
            num1 /= 10;
            num2 /= 10;
        }
        return temp <= k;
    }


    /**
     * 也是典型的dfs题目
     */
    private int count = 0;
    public int movingCount1(int m, int n, int k) {
        boolean[][] isUsed = new boolean[m][n];
        dfs(isUsed, 0, 0, k);
        return count;
    }

    private int[][] next1 = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(boolean[][] isUsed, int m, int n, int k) {
        if (isUsed[m][n]) {
            return;
        }
        if (fun(m, n, k)) {
            return;
        }
        count++;
        isUsed[m][n] = true;
        for (int i = 0; i < 4; i++) {
            int newM = m + next[i][0];
            int newN = n + next[i][1];
            if (newM < 0 || newM == isUsed.length || newN < 0 || newN == isUsed[0].length) continue;
            dfs(isUsed, newM, newN, k);
        }
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
