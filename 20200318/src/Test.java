import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[] {1,2,3,4};
        int[] arr2 = new int[] {1,2,3,4};
        String str = "aaa";
        String str2 = "aaa";
        System.out.println(Arrays.equals(arr, arr2));
        System.out.println(str.equals(str2));
        Random rand = new Random();
        int n = rand.nextInt(4);
        System.out.println(n);
        boolean b = rand.nextBoolean();
        System.out.println(b);

    }
}
