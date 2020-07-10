import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        int k = 0;
        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
            k = Integer.parseInt(s[s.length - 1]);
        }
        Arrays.sort(num, 0, num.length - 1);
        for (int i = 0; i < k; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
