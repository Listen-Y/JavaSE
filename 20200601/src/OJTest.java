import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OJTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String A = scan.next();
            String B = scan.next();
            int count = 0;
            for (int index = 0; index <= A.length() ; index++) {
                StringBuilder builder = new StringBuilder();
                int i = 0;
                for ( ; i < index; i++) {
                    builder.append(A.charAt(i));
                }
                builder.append(B);
                for ( ; i < A.length(); i++) {
                    builder.append(A.charAt(i));
                }
                if (isFun(builder.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
        /*int[] nums = {1,2,3,4};
        System.out.println(findKth(nums, nums.length, 3));*/
    }

    public static boolean isFun(String key) {
        StringBuilder builder = new StringBuilder();
        int i = key.length() - 1;
        while (i >= 0) {
            builder.append(key.charAt(i));
            i--;
        }
        String tmp = builder.toString();
        return key.equals(tmp);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, n - 1);
        System.out.println(Arrays.toString(a));
        return a[K - 1];
    }

    private static void quickSort(int[] array, int length) {
        quickSortHelper(array, 0, length);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = paration(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int paration(int[] array, int left, int right) {
        int base = array[left];
        int leftIn = left;
        int rightIn = right;
        while (leftIn < rightIn) {
            while (leftIn < rightIn && array[rightIn] <= base) {
                rightIn--;
            }
            while (leftIn < rightIn && array[leftIn] >= base) {
                leftIn++;
            }
            if (leftIn < rightIn) {
                int tmp = array[leftIn];
                array[leftIn] = array[rightIn];
                array[rightIn] = tmp;
            }
        }
        array[left] = array[leftIn];
        array[leftIn] = base;
        return leftIn;
    }
}
