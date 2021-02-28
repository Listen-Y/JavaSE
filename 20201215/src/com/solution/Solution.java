package com.solution;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-15
 * Time: 18:53
 */
public class Solution {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 复杂链表是因为节点可能指向一个节点, 递归处理即可
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        RandomListNode temp = new RandomListNode(pHead.label);
        temp.next = Clone(pHead.next);
        if (pHead.random != null) {
            temp.random = new RandomListNode(pHead.random.label);
        }
        return temp;
    }


    /**
     * 由二叉搜索树构建有序双向链表,要注意这个双向链表的头结点就是二叉树中最左边的那个叶子节点
     * 当第一次访问的时候就记录下来, 后续加if判断head以不为空就不在处理head
     * 然后还要有一个变量记录前一个节点, 注意这个前一个节点是双向链表中的前一个节点
     * 也就是第一次记录head的时候才确定第一个pre节点, 后续在对其判不为空 ,修改root.left环绕pre.right
     * 然后再去遍历root的右节点
     */
    TreeNode head, pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        fun(pRootOfTree);
        return head;
    }

    private void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        fun(root.left);
        if (head == null) {
            head = root;
        }
        if (pre != null) {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        fun(root.right);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /*private TreeNode pre, head;*/
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert2(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
        }
        if (pre != null) {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert2(pRootOfTree.right);

        return head;
    }


    /**
     * 这道题就是一个二叉树的中序遍历, 但是要记住访问的次数这应该是一个全局变量, 不能让其是局部变量
     * 不然随着递归的退出, 局部变量是不会由于上次递归造成数据的改变的
     * 还有这是使用的递归, 所以递归函数的退出位置要注意, 不能将判断递归是否进行if加在函数一开头, 这样是不起作用的
     *
     */
    private TreeNode ret;
    private int key;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        key = k;
        fun2(pRoot);
        return ret;
    }

    private void fun2(TreeNode root) {

        if (root == null) {
            return;
        }
        fun2(root.left);
        if (ret != null) {
            return;
        }
        if (key-- == 1) {
            ret = root;
            return;
        }
        fun2(root.right);
    }



    private void test() {
        HashMap<String, String> hashMap = new HashMap<>();

    }

}
