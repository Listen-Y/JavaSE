import java.util.ArrayList;
import java.util.Arrays;

public class SeleteSort {
    //选择排序
    public static void seleteSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int index = bound + 1; index <array.length ; index++) {
                if(array[index] < array[bound]) {
                    int tmp = array[index];
                    array[index] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    //堆排序
    public static void heapSore(int[] array) {
        creatHeap(array);
        //heapsize等于0的时候未排序数组就剩一个元素
        for(int heapSize = array.length - 1; heapSize > 0; heapSize --) {
            int tmp = array[heapSize];
            array[heapSize] = array[0];
            array[0] = tmp;
            //此时数组最后一个元素一定是最大值，我们不对他进行处理了，所以调用向下处理时size就变成index
            shiftDown(array, heapSize, 0);
        }
    }

    private static void creatHeap(int[] array) {
        //向下调整的建堆
        for(int i = (array.length -1 -1) / 2; i >= 0 ; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int chile = 2 * parent + 1;
        while (chile < size) {
            if(chile + 1 < size && array[chile + 1] > array[chile]) {
                chile ++;
            }
            if(array[chile] > array[parent]) {
                int tmp = array[chile];
                array[chile] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = chile;
            chile = 2 * parent + 1;
        }
    }

    //冒泡从前到后进行排序
    public static void bubbling1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //减i是因为已经排序好的我们不对其对行处理，减1是因为防止越界
            for (int j = 0; j < array.length -i -1; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j +1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    //冒泡排序从后到前进行排序
    public static void bubbling2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //j从最后一个元素出发，直到j=i的时候结束，
            // 因为等于i的时候就会和已排序列比较，无意义，而且在i等于0的会发生越界错误
            for (int j = array.length - 1; j > i ; j--) {
                if(array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        //找到返回交换后的基准值的位置
        int index = partition(array,left,right);
        //快速排序基准值左边的数组
        quickSort(array,left,index - 1);
        //快速排序基准值右边的数组
        quickSort(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        //将最右边的元素设置为基准值
        int baseVaule = array[right];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[leftIndex] <= baseVaule) {
                leftIndex ++;
            }
            while (leftIndex < rightIndex && array[rightIndex] >= baseVaule) {
                rightIndex --;
            }
            if(leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        int tmp = array[right];
        array[right] = array[leftIndex];
        array[leftIndex] = tmp;
        return leftIndex;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,5,7,1,8,9,19,10,0};
        //seleteSort(array);
        //heapSore(array);
        //bubbling1(array);
        //bubbling2(array);
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
