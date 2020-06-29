import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReviewSort {
    //选择排序
    public void selectSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int bound = 1; bound < array.length; bound++) {
            for (int i = bound - 1; i >= 0 ; i--) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //希尔排序
    public void shellSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int bound = gap; bound < array.length; bound += gap) {
                for (int i = bound - gap; i >= 0; i -= gap) {
                    if (array[i] > array[i + gap]) {
                        int tmp = array[i];
                        array[i] = array[i + gap];
                        array[i + gap] = tmp;
                    }
                }
            }
            gap /= 2;
        }
    }
    //直接插入排序
    public void insertSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = bound + 1; i < array.length; i++) {
                if (array[i] < array[bound]) {
                    int tmp = array[i];
                    array[i] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    //冒泡排序
    public void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = 0; i < array.length - 1 - bound; i++) {
                if (array[i + 1] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //堆排序
    public void heapSort(int[] array) {
        //升序排序,先对数组进行建大堆处理
        createHeap(array);
        for (int heapSize = array.length - 1; heapSize > 0; heapSize--) {
            int tmp = array[heapSize];
            array[heapSize] = array[0];
            array[0] = tmp;
            shiftDown(array, 0, heapSize);
        }
    }

    private void shiftDown(int[] array, int index, int size) {
        int partent = index;
        int child = 2 * partent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[partent]) {
                int tmp = array[child];
                array[child] = array[partent];
                array[partent] = tmp;
            } else {
                break;
            }
            partent = child;
            child = 2 * partent + 1;
        }
    }

    private void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, i, array.length);
        }
    }
    //快速排序
    public void quickSort(int[] array) {
        //快排采用左闭右闭区间
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = paration(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private int paration(int[] array, int left, int right) {
        int baseValue = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseValue) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= baseValue) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        array[left] = array[leftIndex];
        array[leftIndex] = baseValue;
        return leftIndex;
    }
    //快排非递归
    public void quickSortByLoop(int[] array) {
        if (array.length <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = paration(array, left, right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }
    }
    //归并排序
    public void mergerSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        //归并排序采取左闭又开区间
        mergerSortHelper(array, 0, array.length);
    }

    private void mergerSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int index = (right + left) / 2;
        mergerSortHelper(array, left, index);
        mergerSortHelper(array, index, right);
        merge(array, left, index, right);
    }

    private void merge(int[] array, int left, int index, int right) {
        int leftIndex = left;
        int rightIndex = index;
        int[] tmps = new int[right - left];
        int tmpIndex = 0;
        while (leftIndex < index && rightIndex < right) {
            //加等号为保证稳定性
            if (array[leftIndex] <= array[rightIndex]) {
                tmps[tmpIndex] = array[leftIndex];
                leftIndex++;
            } else {
                tmps[tmpIndex] = array[rightIndex];
                rightIndex++;
            }
            tmpIndex++;
        }
        while (leftIndex < index) {
            tmps[tmpIndex] = array[leftIndex];
            leftIndex++;
            tmpIndex++;
        }
        while (rightIndex < right) {
            tmps[tmpIndex] = array[rightIndex];
            rightIndex++;
            tmpIndex++;
        }
        for (int i = 0; i < tmps.length; i++) {
            array[left + i] = tmps[i];
        }
    }
    //归并非递归
    public void mergeSortByLoop(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int gap = 1; gap < array.length; gap = gap * 2) {
            for (int left = 0; left < array.length; left += 2 * gap) {
                int mid = left + gap;
                int right = mid + gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (right > array.length) {
                    right = array.length;
                }
                merge(array, left, mid, right);
            }
        }
    }
}
