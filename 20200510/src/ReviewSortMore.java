
public class ReviewSortMore {
    public void slelteSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int next = bound + 1; next < array.length; next++) {
                if(array[next] < array[bound]) {
                    int tmp = array[next];
                    array[next] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    //堆排序
    public void heapSort(int[] array) {
        //建立堆
        creatHeap(array);
        //数组交换第一个和最后一个元素，然后进行数组长度减一的向下调整，当长度为
        for (int heapSize = array.length - 1; heapSize > 0; heapSize--) {
            int tmp = array[0];
            array[0] = array[heapSize];
            array[heapSize] = tmp;
            shiftDown(array, heapSize, 0);
        }
    }

    private void creatHeap(int[] array) {
        for (int index = (array.length - 1 - 1) / 2; index >= 0; index--) {
            shiftDown(array, array.length, index);
        }
    }

    private void shiftDown(int[] array, int length, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < length) {
            if(child + 1 < length && array[child + 1] > array[child]) {
                child++;
            }
            if(array[parent] < array[child]) {
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

    //快速排序
    public void quickSort(int[] array) {
        //快排采取，左闭右闭数组区间
        quickSortHealper(array, 0, array.length - 1);
    }

    private void quickSortHealper(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = partition(array, left, right);
        //递归处理左区间和右区间
        quickSortHealper(array, left, index - 1);
        quickSortHealper(array, index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        //定义最左边为基准值，先让right走，找到比基准值小的，再让left走，找比基准值大的
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
                array[rightIndex] = tmp;
            }
        }
        //交换基准值
        int tmp = array[left];
        array[left] = array[leftIndex];
        array[leftIndex] = tmp;
        return leftIndex;
    }

    //归并排序
    public void mergeSort(int[] array) {
        //归并排序采取左闭右开数组区间
        mergeSortHealper(array, 0, array.length);
    }

    private void mergeSortHealper(int[] array, int left, int right) {
        //如果此时区间元素个数为小于1就不进行递归
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHealper(array, left, mid);
        mergeSortHealper(array, mid, right);
        //进行merge操作将俩个有序区间合并
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tmp = new int[right - left];
        int tmpIndex = 0;
        while (leftIndex < mid && rightIndex < right) {
            //为保证稳定性加等号
            if(array[leftIndex] <= array[rightIndex]) {
                tmp[tmpIndex] = array[leftIndex];
                leftIndex++;
            }else {
                tmp[tmpIndex] = array[rightIndex];
                rightIndex++;
            }
            tmpIndex++;
        }
        while (leftIndex < mid) {
            tmp[tmpIndex] = array[leftIndex];
            leftIndex++;
            tmpIndex++;
        }
        while (rightIndex < right) {
            tmp[tmpIndex] = array[rightIndex];
            tmpIndex++;
            rightIndex++;
        }
        //将tmp中的排序好的元素放回到array
        for (int i = 0; i < right - left; i++) {
            array[left + i] = tmp[i];
        }
    }
}
