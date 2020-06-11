import java.util.Stack;

public class SortByLoop {

    //非递归完成快排
    public void quickSortByLoop(int[] array) {
        //用一个栈记录要处理的数组区间
        Stack<Integer> stack = new Stack<>();
        //左边界先入栈，那就右边界先出栈
        //注意快排处理数据的区间是左闭右闭
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            //先出右边界
            int right = stack.pop();
            int left = stack.pop();
            //要注意，当区间没有元素就不进行partition操作
            if(left >= right) {
                continue;
            }
            //进行partition操作返回新的基准值下标
            int index = partition(array, left, right);
            //将左右区间在入栈
            stack.push(left);
            stack.push(index - 1);
            stack.push(index + 1);
            stack.push(right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            //选择最右边数为基准值，所以leftIndex先走
            while (leftIndex < rightIndex && array[leftIndex] <= baseValue) {
                leftIndex++;
            }
            while (leftIndex < rightIndex && array[rightIndex] >= baseValue) {
                rightIndex--;
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

    //非递归完成归并排序
    public void mergeSortBuLoop(int[] array) {
        //gap等于1就是此时分的数组区间是1个元素
        for (int gap = 1; gap < array.length; gap = 2 * gap) {
            for (int left = 0; left < array.length; left += 2 * gap) {
                int mid = left + gap;
                int right = mid + gap;
                if(mid > array.length) {
                    mid = array.length;
                }
                if(right > array.length) {
                    right = array.length;
                }
                //将俩个有序区间合并为一个
                merge(array, left, mid, right);
            }
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tmp = new int[right - left];
        int tmpIndex = 0;
        while (leftIndex < mid && rightIndex < right) {
            //为保证稳定性，得加=
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
            rightIndex++;
            tmpIndex++;
        }
        //将排序好的元素放回到原数组
        for (int i = 0; i < right - left; i++) {
            array[left + i] = tmp[i];
        }
    }
}
