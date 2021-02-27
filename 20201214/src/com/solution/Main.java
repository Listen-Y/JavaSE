package com.solution;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-14
 * Time: 19:51
 */
public class Main {

    /**
     * 二叉树的中序遍历和后序遍历是有关系的, 如果中序遍历是入栈, 那么后续遍历一定是入栈序列的一个出栈序列
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        int[] mid = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(mid);
        int index = 0;
        for (int i = 0; i < mid.length; i++) {
            stack.push(mid[i]);
            while (!stack.isEmpty() && stack.peek() == sequence[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }


    private final ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return ret;
        ArrayList<Integer> list = new ArrayList<>();
        findPathHelper(list, root, 0, target);
        ret.sort((o1, o2) -> o2.size() - o1.size());
        return ret;
    }

    public void findPathHelper(ArrayList<Integer> list, TreeNode root, int add, int target) {

        if (root == null) {
            return;
        }
        if (add + root.val == target && root.left == null && root.right == null) {
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(root.val);
            ret.add(integers);
            return;
        }
        if (add + root.val > target) {
            return;
        }

        list.add(root.val);
        findPathHelper(list, root.left, add + root.val, target);
        findPathHelper(list, root.right, add + root.val, target);
        list.remove(list.size() - 1);
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
     * 节点不为空 ,直接插入, target减去当前值, 如果当前节点为叶子, 并且target为0了, 说明是
     * 一条路径 ,记录他, 然后在递归看起左右节点, 最后删除一开始加进去的节点
     */
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        if (root == null || target < 0) {
            return ret;
        }
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new ArrayList<>(list));
        }
        FindPath1(root.left, target);
        FindPath1(root.right, target);
        list.remove(list.size() - 1);
        return ret;
    }

    /**
     * 先累乘处理下标的前面数字, 然后不管返回结果中的最后一个数字, 再累乘坐标后面数字
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (len <= 1) {
            return A;
        }
        int temp = 1;
        for (int i= 0; i < len; i++) {
            B[i] = temp;
            temp *= A[i];
        }
        temp = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
