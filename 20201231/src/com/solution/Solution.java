package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-31
 * Time: 17:49
 */
import com.demo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Solution {

    /**
     * 用普通链表实现, 效率其实并不好, 模仿层序遍历
     * 思想就是如果是奇数次, 求其个数之后从后往前遍历, 记录, 然后删除这些数据, 并且把这些数据left和right重写加到链表后面
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        int count = 0;
        ArrayList<TreeNode> temp = new ArrayList<>();
        temp.add(pRoot);
        while (!temp.isEmpty()) {
            ArrayList<Integer> nums = new ArrayList<>();
            int size = temp.size();
            if (count % 2 == 0) {
                for (int i = size - 1; i >= 0; i--) {
                    TreeNode cur = temp.get(i);
                    nums.add(cur.val);
                    if (cur.left != null) {
                        temp.add(cur.left);
                    }
                    if (cur.right != null) {
                        temp.add(cur.right);
                    }
                }
                list.add(nums);
                while (size -- > 0) {
                    temp.remove(0);
                }
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    TreeNode cur = temp.get(i);
                    nums.add(cur.val);
                    if (cur.right != null) {
                        temp.add(cur.right);
                    }
                    if (cur.left != null) {
                        temp.add(cur.left);
                    }
                }
                list.add(nums);
                while (size -- > 0) {
                    temp.remove(0);
                }
            }
            count++;
        }
        return list;
    }

    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(pRoot);
        int count = 1;
        while (!stack.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = stack.size();
            if (count % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode cur = stack.poll();
                    temp.add(cur.val);
                    if (cur.right != null) {
                        stack.offer(cur.right);
                    }
                    if (cur.left != null) {
                        stack.offer(cur.left);
                    }
                }
                for (int i = temp.size() - 1; i >= 0; i--) {
                    list.add(temp.get(i));
                }
                temp.clear();
                lists.add(list);
            } else {
                while (size-- > 0) {
                    TreeNode cur = stack.poll();
                    list.add(cur.val);
                    if (cur.right != null) {
                        stack.offer(cur.right);
                    }
                    if (cur.left != null) {
                        stack.offer(cur.left);
                    }
                }
                lists.add(list);
            }
            count++;
        }
        return lists;
    }

    /**
     * 将二叉树序列化成字符串, 采用层序遍历的思想, 但是这次是while循环一次就取一个
     * 如果是null就直接加#,
     * 如果不是null就添加左节点和右节点,append(val ,)
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return builder.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
                builder.append(cur.val).append(',');
            } else {
                builder.append("#,");
            }
        }
        String ret = builder.toString();
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * 这个是反序列化
     * 首先将str进行,分割
     * 如果不是#的下标, 就将其初始化成node节点
     * 然后用双指针i =0和j =1开始, j表示i的左节点和有节点, 如果j符合范围, 并且i为node节点
     * 就将i.left = j++
     * right同理
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] nodes = str.split(",");
        TreeNode[] rets = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#")) {
                rets[i] = new TreeNode(Integer.valueOf(nodes[i]));
            }
        }
        for (int i = 0, j = 1; j < nodes.length; i++) {
            if (rets[i] != null) {
                rets[i].left = rets[j++];
                rets[i].right = rets[j++];
            }
        }
        return rets[0];
    }

}


