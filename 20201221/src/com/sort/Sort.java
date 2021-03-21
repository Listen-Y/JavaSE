package com.sort;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-21
 * Time: 20:21
 */
public class Sort {

    public void quickSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        quickSOrtHelper(array, 0, array.length - 1);
    }

    private void quickSOrtHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = peroration(array, left, right);
        quickSOrtHelper(array, left, mid - 1);
        quickSOrtHelper(array, mid + 1, right);
    }

    private int peroration(int[] array, int left, int right) {
        int baseVal = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseVal) {
                rightIndex --;
            }
            while (leftIndex<rightIndex && array[leftIndex] <= baseVal) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }
        }
        array[left] = array[leftIndex];
        array[leftIndex] = baseVal;
        return leftIndex;
    }

    public void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        mergeSortHelper(array, 0, array.length);
    }

    private void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left +right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tempArray = new int[array.length];
        int tempIndex = 0;
        while (leftIndex < mid && rightIndex < right) {
            if (array[leftIndex] <= array[rightIndex]) {
                tempArray[tempIndex] = array[leftIndex];
                leftIndex++;
            } else {
                tempArray[tempIndex] = array[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        while (leftIndex < mid) {
            tempArray[tempIndex] = array[leftIndex];
            leftIndex++;
            tempIndex++;
        }
        while (rightIndex < right) {
            tempArray[tempIndex] = array[rightIndex];
            rightIndex++;
            tempIndex++;
        }
        for (int i = 0; i < tempIndex; i++) {
            array[left + i] = tempArray[i];
        }
    }
}
