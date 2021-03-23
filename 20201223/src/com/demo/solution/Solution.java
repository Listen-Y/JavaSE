package com.demo.solution;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-23
 * Time: 17:31
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 返回链表中第一个公共节点, 使用队列记住链表1的节点, 然后在链表2中进行遍历查找
     * 每次都是链表1的节点进行入队, 出队, 但是记着判断, 如果出队为null直接返回null
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Queue<ListNode> queue = new LinkedList<>();
        if (pHead2 == null || pHead1 == null) {
            return null;
        }
        ListNode temp = pHead1;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            ListNode temp2 = pHead2;
            if (cur == null || contaions(cur, temp2)) {
                return cur;
            }
            queue.offer(cur.next);
        }
        return null;
    }

    private boolean contaions(ListNode cur, ListNode temp2) {
        while (temp2 != null) {
            if (cur == temp2) {
                return true;
            } else {
                temp2 = temp2.next;
            }
        }
        return false;
    }

    /**
     * 利用二分查找找到排序数组中关键下标, 注意二分查找的区间是左闭右开式, 那样采用俩下标相减的数据才是真的数量
     * 如果是最后一个比三小的数据
     * 那么如果此时是大于等于3 那么就让right等于mid, 否则left = mid + 1, 也就是让最终左下标往右靠
     * 让最终right=left的时候是在第一个3下标处
     * 那么找第一个大于3的数字的时候
     * 还是让左往右靠, 小于等于3的时候left = mid + 1
     * 大于3的时候就right = mid
     *
     * 所有俩边都是采用左往右靠, 这样相减才是数量
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array ==null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length;
        int left = 0;
        while (low < high){
            int mid = (low + high) >> 1;
            if (array[mid] >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        left = low;
        low = 0;
        high = array.length;

        while (low < high){
            int mid = (low + high) >> 1;
            if (array[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - left;
    }


    /**
     * 一道深度探索的题
     * 走过的记录为1 每次都遍历方向数组记录newX和newY, 如果边界有误就continue
     * 使用newX和newY就可以省去恢复操作
     */
    private int[][] dir = {{0, 1}, {1,0}, {0, -1},{-1, 0}};
    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        int[][] used = new int[rows][cols];
        return dfs(0, 0, used, threshold);
    }

    private int dfs(int x, int y, int[][] used, int threshold) {
        if (add(x, y, threshold) || used[x][y] == 1) {
            return 0;
        }
        used[x][y] = 1;
        int ret = 1;
        for (int i= 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (newX < 0 || newX >= used.length || newY < 0 || newY >= used[0].length) continue;
            ret += dfs(newX, newY, used, threshold);
        }
        return ret;
    }

    private boolean add(int x, int y, int threshold) {
        int sum = 0;
        while (x > 0) {
            int temp = x % 10;
            sum += temp;
            x /= 10;
        }
        while (y > 0) {
            int temp = y % 10;
            sum += temp;
            y /= 10;
        }
        return sum > threshold;
    }


    /**
     * 不喜欢做这种题, 很难受, 完全不会
     * num2! =0
     * temp = num1 ^ num2;
     * num2 = (num1&num2) << 1
     * num1 = temp;
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
