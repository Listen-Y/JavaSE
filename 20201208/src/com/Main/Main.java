package com.Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-08
 * Time: 16:45
 */
public class Main {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int value : pushA) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                assert temp != null;
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
        }
        return list;
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
     * select
     * de.name as Department,
     * em.name as Employee,
     * Salary
     * from Employee em
     * join
     * Department de
     * on
     * em.DepartmentId = de.Id
     * where
     * (em.Salary, em.DepartmentId)
     * in
     * (select MAX(Salary), DepartmentId from Employee group by DepartmentId);
     */

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("haha");
    }

}
