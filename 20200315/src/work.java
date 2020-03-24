import java.util.Arrays;

public class work {
    public static void main(String[] args) {
        int[] str = new int[] {1,3,4,6,7,4,3,5,7};
        /*Arrays.sort(str);
        System.out.println(Arrays.toString(copyOf(str)));
        if(ifArraysOrderly(str)) {
            System.out.println("有序");
        }else {
            System.out.println("无序");
        }
*/
        System.out.println(arraysToString(str));
    }

    public static int[] copyOf(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i] + 1;
        }
        return arr2;
    }

    public static boolean ifArraysOrderly(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static String arraysToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }
}
