import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
        //System.out.println(halfSearch(arr, 7));
        int[] arr2 = {3,4,6,5,33,5,67,543};
        moPaoPao(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static int halfSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] < key) {
                low = mid + 1;
            }else if(arr[mid] > key) {
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void moPaoPao(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                k = arr[j + 1]; arr[j + 1] = arr[j]; arr[j] = k;
                }
            }
        }
    }
}
