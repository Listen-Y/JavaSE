package com.solution;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-05
 * Time: 11:11
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(3);
        TreeNode treeNode = fanZh(head);
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.left;
        }
    }

    /**
     * 括号匹配
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char out = stack.peek();
                if (ch == ')' && out == '(') {
                    stack.pop();
                    continue;
                }
                if (ch == ']' && out == '[') {
                    stack.pop();
                    continue;
                }
                if (ch == '}' && out == '{') {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 二维数组查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length - 1;
        int start = 0;
        while (start < row && col >= 0) {
            int num = matrix[start][col];
            if (num < target) {
                start++;
            } else if (num > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }



static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 重建二叉树
     * 记录此时中序遍历根节点的位置和另一个边界, 如果是设置左节点记录的就是le+pos
     * 如果记录的是右节点, 则记录的是pos+1 ri
     */
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int leftIndex, int rightIndex) {
        if (index >= preorder.length) {
            return null;
        }
        if (leftIndex >= rightIndex) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        int pos = findPos(inorder, node.val);
        node.left = buildTreeHelper(preorder, inorder, leftIndex, pos);
        node.right = buildTreeHelper(preorder, inorder, pos + 1, rightIndex);
        return node;
    }

    private int findPos(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二叉树装入二维链表
     */
    private List<List<Integer>> result;
    public List<List<Integer>> findPath(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPathHelper(root, 0);
        return result;
    }

    private void findPathHelper(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (result.size() <= i) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(i);
        list.add(root.val);
        findPathHelper(root.left, i + 1);
        findPathHelper(root.right, i + 1);
    }

    public static TreeNode fanZh(TreeNode head) {
        if (head == null || head.left == null) {
            return head;
        }
        TreeNode one = head;
        TreeNode two = head.left;
        while (two != null) {
            TreeNode three = two.left;
            two.left = one;
            one = two;
            two = three;
        }
        head.left = null;
        return one;
    }



}
