package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-26
 * Time: 20:15
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(flowers(new int[] {0, 3,2,1,2,3}));
    }

    public static int flowers(int[] stu) {
        if (stu.length <= 1) {
            return stu[0];
        }
        int sum = 0;
        for (int i = 0; i < stu.length; i++) {
            int temp = 1;
            if (stu[i] == 0) {
                sum += temp;
                continue;
            }
            if (i == 0) {
                int index = i;
                while (index < stu.length && (stu[index + 1] < stu[index])) {
                    index++;
                    temp++;
                }
                sum += temp;
            } else if (i == stu.length - 1) {
                int index = i;
                while (index > 0 && stu[index - 1] < stu[index]) {
                    index--;
                    temp++;
                }
                sum += temp;
            } else {
                int left = 1;
                int right = 1;
                int index = i;
                while (index > 0 && (stu[index - 1] < stu[index])) {
                    left++;
                    index--;
                }
                index = i;
                while (index < stu.length && (stu[index] > stu[index + 1])) {
                    right++;
                    index++;
                }
                sum += Math.max(left, right);
            }
        }
        return sum;
    }


    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 实现将n个围城一圈, 然后遍历count++
     * 如果为m - 1了就temp.next = temp.next.next
     * 所以temp每次指向的是要删去节点的上一个节点
     * 而且要注意while结束条件是len > 1
     * 如果删除了节点的话就不能再往下移动, 因为下一个也要计数
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        Node head = new Node(0);
        Node temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        temp.next = head;
        int count = 0;
        int len = n;
        while (len > 1) {
            if (count == m - 1) {
                temp.next = temp.next.next;
                len--;
            } else {
                temp = temp.next;
            }
            count++;
            if (count == m) {
                count = 0;
            }
        }
        return temp.val;
    }


    /**
     * 按下标进行基数统计很好做
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length < 1) {
            return false;
        }
        int[] temps = new int[length];
        for (int i = 0; i < length; i++) {
            temps[numbers[i]]++;
            if (temps[numbers[i]] == 2) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 找到中序遍历下的下一个节点
     * 如果当前为null 直接返回
     * 如果当前的right不为null, 则走到当前的right的最左节点返回
     * 如果有父节点, 看此时的节点是不是左节点, 如果是直接返回父节点, 如果不是则往上走, 直到找到是左节点
     * 如果都没有找到, 就返回null
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
