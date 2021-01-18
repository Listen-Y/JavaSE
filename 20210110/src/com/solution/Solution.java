package com.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-10
 * Time: 12:12
 */
public class Solution {

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

        }
    });


    /**
     * 全排列问题, 主要就是for i从index开始, 如果与下标不同, 但是数字相同就continue;
     */
    List<List<Integer>> ans;
    public List<List<Integer>> allKinds(int[] nums) {
        ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(nums, ans, 0);

        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, int index) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums
                 ) {
                list.add(num);
            }
            ans.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[index]) {
                continue;
            }
            swap(nums, i, index);
            dfs(nums, ans, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int index) {

        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }


    static class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
 }

    public boolean[] judgeIt (TreeNode root) {
        // write code here
        return new boolean[] {isSort(root, Integer.MIN_VALUE, Integer.MAX_VALUE), isCom(root)};
    }

    /**
     * 判断是否为二叉搜索树, 给定最大值和最小值, 如果此时节点不为null 初始的最大值和最小值是int的值
     * 如果小于最小值或者大于最大值都返回false
     * 否则判断其左节点和右节点
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isSort(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min ||root.val > max) {
            return false;
        }
        return isSort(root.left, min, root.val) && isSort(root.right, root.val, max);
    }

    /**
     * 这个是判断是否为完全二叉树, 给定一个队列,如果队列不为空遍历队列, 不为null添加其左节点和右节点
     * 一旦遇到null退出
     * 再看这个null后面再有没有不是null的节点, 一旦有说明不是完全的
     * 没有说明是完全的
     * @param root
     * @return
     */
    private boolean isCom(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                break;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }

    public Node getNode(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        boolean find = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast== slow) {
                find = true;
                break;
            }
        }
        if (find) {
            slow = head;
            while (slow.val != fast.val) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }


}
