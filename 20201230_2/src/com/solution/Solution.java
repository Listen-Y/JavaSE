package com.solution;

import java.util.*;

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
            //如果说当前节点的右节点为空, 或者说当前节点的右子树被访问过, 这说明这个节点可以直接访问呢
            if (node.right == null || node.right == prev) {
                System.out.print(node.val);
                prev = node;
                stack.pop();
            } else {
                cur = node.right;
            }
        }


    }

    /**
     * 简单的层序遍历
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(temp);
        }
        return list;
    }



    private PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
    private int count = 0;

    /**
     * 数据流的中位数, 将数据放到大堆和小堆中, 并且放完大堆就将大堆中的最大的数放到小堆中
     * 放完小堆就将最小的数放到大堆中, 这样大堆的堆顶放的便是小数字中的最大数, 小堆中放的就是大堆中的最小数
     * 如果放入的总数为奇数, 直接去小堆堆顶, 放入的是偶数, 取俩头, 然后取平均即可
     * 注意这里的取不是poll. 而是peek 不然就会出错
     * @param num
     */
    public void Insert(Integer num) {

        if (count % 2 == 0) {
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
        } else {
            smallHeap.offer(num);
            bigHeap.offer(smallHeap.poll());
        }
        count++;

    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            int sum = bigHeap.peek() + smallHeap.peek();
            return (Double) (sum * 1.0) / 2;
        } else {
            return new Double(smallHeap.peek());
        }
    }
}
