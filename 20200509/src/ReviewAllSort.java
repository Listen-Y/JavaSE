import sun.util.resources.cldr.ii.CalendarData_ii_CN;

import java.util.Arrays;
import java.util.Stack;

/**
 * 全写降序
 */
public class ReviewAllSort {
    //插入排序
    public  void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            for (int prevBound = bound - 1; prevBound >= 0 ; prevBound--) {
                //前面的数字小于后面的一个就互换值
                if(array[prevBound] < array[prevBound + 1]) {
                    int tmp = array[prevBound];
                    array[prevBound] = array[prevBound + 1];
                    array[prevBound + 1] = tmp;
                }
            }
        }
    }
    //希尔排序
    public void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap >= 1) {
            //按照插入排序那样写，也就是说当gap为1的时间就是一个简单的插入排序
            for (int bound = gap; bound < array.length; bound++) {
                for (int prevBound = bound - gap; prevBound >= 0; prevBound -= gap) {
                    if(array[prevBound] < array[prevBound + gap]) {
                        int tmp = array[prevBound];
                        array[prevBound] = array[prevBound + gap];
                        array[prevBound + gap] = tmp;
                    }
                }
            }
            gap /= 2;
        }
    }
    //选择排序
    public void seleteSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int nextBound = bound + 1; nextBound < array.length; nextBound++) {
                //nextBound表示bound的后面元素的下标，如果大于bound下标的元素就互换值
                if(array[nextBound] > array[bound]) {
                    int tmp = array[nextBound];
                    array[nextBound] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    //堆排序
    public void heapSort(int[] array) {
        //先建立小堆
        createHeap(array);
        //数组长度减一,第一个元素与最后一个元素互换值，并且将第一个元素进行向下调整,直到最后heapSize=1
        for (int heapSize = array.length - 1; heapSize > 0; heapSize--) {
            int tmp = array[0];
            array[0] = array[heapSize];
            array[heapSize] = tmp;
            shiftDown(array,heapSize,0);
        }
    }

    private void createHeap(int[] array) {
        //inde -1是因为得到最后一个元素再-1是为了/2找到其父亲结点
        for (int index = (array.length - 1 - 1) / 2; index >= 0; index--) {
            shiftDown(array,array.length,index);
        }
    }

    private void shiftDown(int[] array, int length, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < length) {
            //如果其右结点值更小
            if(child + 1 < length && array[child + 1] < array[child]) {
                child ++;
            }
            //如果父亲结点的值大于孩子结点的值就交换
            if(array[parent] > array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;

        }
    }
    //冒泡排序
    public void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //i从第一个位置开始进行比较，直到已排好序列的前一个元素
            for (int i = 0; i < array.length - 1 - bound; i++) {
                //若是后面大于前面就互换值
                if(array[i + 1] > array[i]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
    //快速排序
    public void quickSort(int[] array) {
        //用辅助方法执行，快排区间使用左闭有闭的区间
        quickSortHealer(array,0,array.length - 1);
    }

    private void quickSortHealer(int[] array, int left, int right) {
        //说明此时区间没有元素
        if(left >= right) {
            return;
        }
        //返回基准值的位置
        int index = partition(array,left,right);
        //递归处理其左右区间
        quickSortHealer(array,left,index - 1);
        quickSortHealer(array,index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        //选取最左边是基准值
        int baseValue = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            //选取最左边为基准值，所有先让右边移动,找大于基准值的元素
            while (leftIndex < rightIndex && array[rightIndex] <= baseValue) {
                rightIndex--;
            }
            //右边走，找小于基准值的元素
            while (leftIndex < rightIndex && array[leftIndex] >= baseValue) {
                leftIndex++;
            }
            if(leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        //将重合的下标与基准值进行交换
        int tmp = array[leftIndex];
        array[leftIndex] = array[left];
        array[left] = tmp;
        return leftIndex;
    }
    //快速排序非递归
    public void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        //将左右下标入栈,先入左，再入右
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            //将左右下标出栈，要先出右，再出左
            int right = stack.pop();
            int left = stack.pop();
            //只要此区间没有元素或者防止越界就继续出栈
            if(left >= right) {
                continue;
            }
            //进行partition操作，返回基准值下标
            int index = partition(array,left,right);
            //将左右区间下标再入栈，还是按照先入左，再入右
            //入左区间
            stack.push(left);
            stack.push(index - 1);
            //入右区间
            stack.push(index + 1);
            stack.push(right);
        }
    }
    //归并排序
    public void mergeSort(int[] array) {
        //归并排序区间，采取左闭右开
        mergeSortHealper(array,0,array.length);
    }

    private void mergeSortHealper(int[] array, int left, int right) {
        //若果此时区间就只有一个或一个以下的元素，就结束递归
        if(right - left <= 1) {
            return;
        }
        //只要此时区间元素大一1个就进行分组递归处理
        int mid = (left + right) / 2;
        mergeSortHealper(array,left,mid);
        mergeSortHealper(array,mid,right);
        //进行merge操作，将俩个有序序列合并为一个有序序列
        merge(array,left,mid,right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tmpNums = new int[right - left];
        int tmpIndex = 0;
        //合并
        while (leftIndex < mid && rightIndex < right) {
            //等号不可省，为了保证稳定性
            if(array[leftIndex] >= array[rightIndex]) {
                tmpNums[tmpIndex] = array[leftIndex];
                leftIndex ++;
            }else {
                tmpNums[tmpIndex] = array[rightIndex];
                rightIndex ++;
            }
            tmpIndex ++;
        }
        //若俩个区间任何一个还有剩余元素为排序
        while (leftIndex < mid) {
            tmpNums[tmpIndex] = array[leftIndex];
            leftIndex ++;
            tmpIndex ++;
        }
        while (rightIndex < right) {
            tmpNums[tmpIndex] = array[rightIndex];
            rightIndex ++;
            tmpIndex ++;
        }
        //将排好序的元素放回到原数组中
        for (int i = 0; i < right - left; i++) {
            array[left + i] = tmpNums[i];
        }
    }
    //归并排序非递归
    public void mergeSortByLoop(int[] array) {
        //合理处理下标进行分组然后合并排序
        //gap为一，一个组的元素个数就为一，
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                int left = i;
                int mid = i + gap;
                int right = mid + gap;
                //防止越界
                if(mid > array.length) {
                    mid = array.length;
                }
                if(right > array.length) {
                    right = array.length;
                }
                //进行merge操作
                merge(array,left,mid,right);
            }
        }
    }
    //计数排序
    public void countSort(int[] array) {
        //找到数组里的最大值
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        //创建一个大小为所有元素最大值的数组
        int[] countArray = new int[array.length - 1];

    }
}
