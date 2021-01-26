import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-19
 * Time: 21:18
 */
public class Demo {
    public static void main(String[] args) {
/*        Solution solution = new Solution();
        for (String s : solution.permutation("kzfxxx")) {
            System.out.println(s);
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String s = "";
        StringBuilder builder = new StringBuilder();
        builder.append("a");*/

        Demo demo = new Demo();
        int[] array = new int[] {9,8,7,6,5,4,3,2,1};
        demo.mergeSort(array);
        System.out.println(Arrays.toString(array));

    }

    public void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = par(array, left, right);
        quickSortHelper(array, left, pos - 1);
        quickSortHelper(array, pos + 1, right);
    }

    private int par(int[] array, int left, int right) {
        int baseVal = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseVal) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= baseVal) {
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

    static class Node {
        int val;
        Node next;

        public Node(int vai) {
            this.val = val;
        }
    }

    public Node deleteNumKth(Node head, int k) {
        if (k < 0 || head == null) {
            return null;
        }
        Node quick = head;
        while (quick != null && k-- > 0) {
            quick = quick.next;
        }
        if (quick == null) {
            return null;
        }
        Node per = head;
        Node smart = head;
        while (quick.next != null) {
            per = smart;
            smart = smart.next;
            quick = quick.next;
        }
        if (smart != null) {
            per.next = smart.next;
        }
        return head;

        /**
         * name class score tb1
         *
         * select count(name) from tb1 group by class having min(score) > 60;
         */
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
        int mid = (left + right) >> 1;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] temps = new int[right - left];
        int index = 0;
        while (leftIndex < mid && rightIndex < right) {
            if (array[leftIndex] <= array[rightIndex]) {
                temps[index++] = array[leftIndex];
                leftIndex++;
            } else {
                temps[index++] = array[rightIndex];
                rightIndex++;
            }
        }
        while (leftIndex < mid) {
            temps[index++] = array[leftIndex];
            leftIndex++;
        }
        while (rightIndex < right) {
            temps[index++] = array[rightIndex];
            rightIndex++;
        }
        for (int i = 0; i < index; i++) {
            array[left + i] = temps[i];
        }
    }
}
