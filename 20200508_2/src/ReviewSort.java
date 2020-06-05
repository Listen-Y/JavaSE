import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class ReviewSort {
    //直接插入排序
    public void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            for (int prevBound = bound - 1; prevBound >= 0; prevBound--) {
                if(array[prevBound] > array[prevBound + 1]) {
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
            for (int bound = gap; bound < array.length ; bound++) {
                for (int prevBound = bound - gap; prevBound >= 0 ; prevBound--) {
                    if(array[prevBound] > array[prevBound + gap]) {
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
    public void checkSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = bound + 1; i < array.length; i++) {
                if(array[i] < array[bound]){
                    int tmp = array[i];
                    array[i] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    //堆排序
    public void heapSort(int[] array) {
        createHeap(array);
        //直接将数组长度减一，下次向下调整对最后一个元素不做处理，heapSize等于0的时候就只有一个元素为排序
        for (int heapSize = array.length - 1; heapSize > 0; heapSize--) {
            int tmp = array[0];
            array[0] = array[heapSize];
            array[heapSize] = tmp;
            shiftDown(array,heapSize,0);
        }
    }

    private void createHeap(int[] array) {
        //第一次减一是得到最后一个元素，在减一是为了找它的双亲结点
        for (int i = (array.length -1 - 1) / 2; i >= 0 ; i--) {
            shiftDown(array,array.length,i);
        }
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child  = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] > array[ child]) {
                child ++;
            }
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child  = 2 * parent + 1;
        }
    }

    //冒泡排序，从前到后
    public void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //最后一个元素不用排序所以减一，已排好的bound个也不用对其进行比较处理
            for (int i = 0; i < array.length -1 -bound; i++) {
                if(array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //冒泡排序从后到前
    public void bubbleSort1(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for(int i = array.length - 1; i > bound; i --) {
                if(array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }
        }
    }

    //快速排序
    public void quickSort(int[] array) {
        quickSortDeal(array, 0, array.length - 1);
    }

    private void quickSortDeal(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = partition(array,left,right);
        quickSortDeal(array,left,index - 1);
        quickSortDeal(array,index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        //选取最左边为基准值
        int baseVaule = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseVaule) {
                rightIndex --;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= baseVaule) {
                leftIndex ++;
            }
            if(leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        //此时leftIndex和rightIndex下标的元素一定小于或者等于我们选取的基准值
        //若是因为rightIndex下标导致结束循环，那么rightIndex下标未找到比基准值小的数据，最后导致重合。
        //若是因为leftIndex下标导致结束循环，那么说明rightIndex已经找到比基准值小的元素，最后重合与基准值交换。
        int tmp = array[leftIndex];
        array[leftIndex] = array[left];
        array[left] = tmp;
        return leftIndex;
    }

    //优化后的快速排序
    public void betterQuickSort(int[] array) {
        betterQuickSortDeal(array, 0, array.length - 1);
    }

    private void betterQuickSortDeal(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = betterQartition(array,left,right);
        betterQuickSortDeal(array,left,index - 1);
        betterQuickSortDeal(array,index + 1, right);
    }

    private int betterQartition(int[] array, int left, int right) {
        int baseVaule = findBetterBaseVaule(array, left, right);
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseVaule) {
                rightIndex --;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= baseVaule) {
                leftIndex ++;
            }
            if(leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        int tmp = array[leftIndex];
        array[leftIndex] = array[left];
        array[left] = tmp;
        return leftIndex;
    }

    private int findBetterBaseVaule(int[] array, int left, int right) {
        if(array.length < 3) {
            return array[left];
        }
        int[] nums = new int[3];
        nums[0] = array[left];
        nums[1] = array[right];
        Random rand = new Random();
        //选取（left，right）下标中间的一个随机值
        int ra = rand.nextInt(right) + left + 1;
        nums[2] = array[ra];
        Arrays.sort(nums);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == nums[1]) {
                array[i] = array[left];
                array[left] = nums[1];
                break;
            }
        }
        return array[left];
    }

    //非递归实现快速排序
    public void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        //左边界先入栈
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            //右边界先出栈
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right) {
                continue;
            }
            int index = partition(array, left,right);
            //讲左边区间入栈，还要注意左边界先入栈
            stack.push(left);
            stack.push(index - 1);
            //将右边区间入栈
            stack.push(index + 1);
            stack.push(right);
        }
    }

    //归并排序
    public void mergeSort(int[] array) {
        //归并排序区间采用左闭右开格式，快排采用左闭右闭格式
        mergeSortHealper(array, 0, array.length);
    }

    private void mergeSortHealper(int[] array, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHealper(array,left,mid);
        mergeSortHealper(array,mid,right);
        merge(array,left,mid,right);
    }
    //将俩个有序序列合并为一个有序序列
    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tmpNums = new int[right - left];
        int tmpIndex = 0;
        while (leftIndex < mid && rightIndex < right) {
            if(array[leftIndex] <= array[rightIndex]) {
                tmpNums[tmpIndex] = array[leftIndex];
                tmpIndex ++;
                leftIndex ++;
            }else {
                tmpNums[tmpIndex] = array[rightIndex];
                tmpIndex ++;
                rightIndex ++;
            }
        }
        while (leftIndex < mid) {
            tmpNums[tmpIndex] = array[leftIndex];
            tmpIndex ++;
            leftIndex ++;
        }
        while (rightIndex < right) {
            tmpNums[tmpIndex] = array[rightIndex];
            tmpIndex ++;
            rightIndex ++;
        }
        for (int i = 0; i < right - left; i++) {
            array[left + i] = tmpNums[i];
        }
    }

    //归并排序的非递归实现
    public void mergeSortByLoop(int[] array) {
        //gap表示多少个元素一组
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int left = 0; left < array.length; left += 2 * gap) {
                int mid = left + gap;
                int right = mid + gap;
                //防止数据越界访问
                if(mid > array.length) {
                    mid = array.length;
                }
                if(right > array.length) {
                    right = array.length;
                }
                merge(array,left,mid,right);
            }
        }
    }
}
