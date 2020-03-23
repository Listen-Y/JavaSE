import java.util.Arrays;
import java.util.Scanner;

/*
public class ARRAYS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        //System.out.println(avg(arr));
        //System.out.println(add(arr));
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(transform(arr)));
        //printArrays(arr);
        setArrarNums();
    }

    public static float avg(int[] arr) {
        float sum = 0f;
        for (int i : arr
             ) {
            sum += i;
        }
        return sum / arr.length;
    }

    public static int add(int[] arr) {
        int sum = 0;
        for (int i : arr
        ) {
            sum += i;
        }
        return sum;
    }

    public static int[] transform(int[] arr) {
        //int[] arr2 = arr.clone();
        int[] arr2 = new int[arr.length];
                //System.arraycopy(arr, 0, arr2, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i] * 2;
        }
        return arr2;
    }

    public static void printArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
       String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length -1) {
                str += ',';
            }
        }
        str = str + "]";
        System.out.println(str);
    }
    
    public static void setArrarNums() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
*/

public class ARRAYS {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(a));
        int[] b = new int[a.length];
               b = a.clone();
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] + 1;
        }
        int[] c = new int[b.length];
        System.arraycopy(b,0,c,0,b.length);
        for (int i = 0; i < a.length; i++) {
            c[i] = b[i] + 1;
        }
        int[] d = new int[c.length];
        Arrays.copyOf(d,c.length);
        for (int i = 0; i < a.length; i++) {
            d[i] = c[i] + 1;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));

    }
}
