import com.sun.javafx.webkit.UtilitiesImpl;

public class SortTest {
    //插入排序
    public void insertSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        for (int bound = 1; bound < array.length; bound++) {
            for (int i = bound - 1; i >= 0 ; i--) {
                if(array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i +1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //希尔排序
    public void shellSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int bound = gap; bound <array.length; bound++) {
                for (int i = bound - gap; i >= 0; i -= gap) {
                    if(array[i] > array[i + gap]) {
                        int tmp = array[i];
                        array[i] = array[i + gap];
                        array[i + gap] = tmp;
                    }
                }
            }
            gap /= 2;
        }
    }
    //选择排序
    public void seleteSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = bound + 1; i < array.length; i++) {
                if(array[i] < array[bound]) {
                    int tmp = array[i];
                    array[i] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    //冒泡
    public void bubbleSort(int[] array) {
        if(array.length <= 1) {
            return;
        }
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = 0; i < array.length - 1 - bound; i++) {
                if(array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //堆排序
    public void heapSort(int[] array) {
        createHeap(array);
        for (int heapsize = array.length - 1; heapsize > 0; heapsize--) {
            int tmp = array[0];
            array[0] = array[heapsize];
            array[heapsize] = tmp;
            shiftDown(array, heapsize, 0);
        }
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
    //快排
    public void quickSort(int[] array) {
        quickSortHealper(array, 0, array.length - 1);
    }

    private void quickSortHealper(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHealper(array, left, index - 1);
        quickSortHealper(array, index +1, right);
    }

    private int partition(int[] array, int left, int right) {
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
            if(leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex]= tmp;
            }
        }
        int tmp = array[left];
        array[left] = array[leftIndex];
        array[leftIndex] = tmp;
        return leftIndex;
    }
    //归并
    public void mergeSort(int[] array) {
        //归并排序区间为左闭右开
        mergeSortHeapler(array, 0, array.length);
    }

    private void mergeSortHeapler(int[] array, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSortHeapler(array, left, mid);
        mergeSortHeapler(array, mid, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tmp = new int[right - left];
        int index = 0;
        while (leftIndex < mid && rightIndex < right) {
            if(array[leftIndex] <= array[rightIndex]) {
                tmp[index] = array[leftIndex];
                leftIndex++;
            } else {
                tmp[index] = array[rightIndex];
                rightIndex++;
            }
            index++;
        }
        while (leftIndex < mid) {
            tmp[index] = array[leftIndex];
            leftIndex++;
            index++;
        }
        while (rightIndex < right) {
            tmp[index] = array[rightIndex];
            rightIndex++;
            index++;
        }
        for (int i = 0; i < right - left; i++) {
            array[left + i] = tmp[i];
        }
    }

}
