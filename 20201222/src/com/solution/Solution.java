package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-22
 * Time: 20:55
 */
public class Solution {


    /**
     * 这道题就是典型的大数据思维
     * 因为归并排序是由分散和合并组成
     * 所以在合并的时候, 每一部分都是有序的
     * 所以在对比的时候就可以少去很多的对比
     * 比如俩个倒序数据段,第一段的第一个数据大于第二段的第一个数据,
     * 那么前一段的第一个数据肯定是大于后一段所有数据的
     * 也就说前一段的数据大于的个数就是后一段最大下标减去此时后一段的被比较数据的下标
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        return mergeSort(array, 0, array.length);
    }

    private int mergeSort(int[] array, int left, int right) {
        if (right - left <= 1) {
            return 0;
        }
        int mid = (left + right) / 2;
        int ret = 0;
        ret += mergeSort(array, left, mid);
        ret %= 1000000007;
        ret += mergeSort(array, mid, right);
        ret %= 1000000007;
        ret += merge(array, left, mid, right);
        return  ret % 1000000007;
    }

    private int merge(int[] array, int left, int mid, int right) {
        int ret = 0;
        int leftIndex = left;
        int rightIndex = mid;
        int[] temp = new int[right - left];
        int tempIndex = 0;
        while (leftIndex < mid && rightIndex < right) {
            if (array[leftIndex] > array[rightIndex]) {
                ret += right - mid;
                ret %= 1000000007;
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }
        while (leftIndex < mid) {
            temp[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex < right) {
            temp[tempIndex++] = array[rightIndex++];
        }
        for (int i = 0; i < tempIndex; i++) {
            array[left + i] = temp[i];
        }
        return ret;
    }
}
