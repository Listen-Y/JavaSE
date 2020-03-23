import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CHAR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] ch = new char[] {'a', 'b', 'c', 'e', 's', 'd'};
        char[] ch2 = new char[3];
        int[] arr = new int[] {3,4,5,2,6,867,43,1,3,556,34,234,56};
        boolean[] str = new boolean[3];
        //inputChar(ch2);
        //arraysOfsort(ch);
        //System.out.println(arraysOfBinarySearch(ch, 'c'));
        arraysOfStringGill(str);
        System.out.println(Arrays.toString(str));
    }

    public static void  inputChar(char[] ch2) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < ch2.length; i++) {
            ch2[i] = scan.next().charAt(0);
        }
        System.out.println(Arrays.toString(ch2));
    }

    public static void arraysOfsort(char[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int arraysOfBinarySearch(char[] arr, char key) {
        return Arrays.binarySearch(arr, key);
    }

    public static void arraysOfStringGill(boolean[] str) {
        Arrays.fill(str, true);
    }
}
