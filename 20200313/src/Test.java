import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*char[] str= new char[10];
        for (int i = 0; i < str.length; i++) {
            str[i] = scan.next();
        }
        System.out.println(Arrays.toString(str));*/
        int[] a = new int[]{1,2,3};
        int[] b = copyArray(a);
        System.out.println(Arrays.toString(b));
    }
    public static int[] copyArray(int[] array) {
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            b[i] = array[i];
        }
        return b;
    }
}
