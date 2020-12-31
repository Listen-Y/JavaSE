package com.solution;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-30
 * Time: 13:46
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {



    /**
     * 判断一棵二叉树是否对称相等, 首先看起更节点如果为null返回true
     * 其次看其左右子树, 如果都是空, 然后true , 如果有一方为null或者俩个节点的值不同, 则直接返回false
     * 否则, 递归看起左子树的左节点和右子树的右节点, 并且左子树的右节点和右子树的左节点
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return fun(pRoot.left, pRoot.right);
    }

    private boolean fun(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return fun(left.left, right.right) && fun(left.right, right.left);
    }

    /**
     * 非递归实现先序遍历, 栈先放右再放左
     * @param root
     */
    public void bigSort(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 非递归中序遍历
     * @param root
     */
    public void midSort(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

    /**
     *
     */
    public void  lastSort(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode node = stack.peek();
            if (node.right == null && prev != node) {
                System.out.print(node.val);
                prev = node;
                stack.pop();
            } else {
                cur = node.right;
            }
        }
    }
}
