import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,3,6,4,8,3,6,4,2,5};
        System.out.println(Arrays.toString(function(arr)));
    }

    public static int[] function(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            while(low < high && arr[low] % 2 == 0) {
                low ++;
            }
            while(low < high && arr[high] % 2 != 0) {
                high --;
            }
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        }
        return arr;
    }
}
