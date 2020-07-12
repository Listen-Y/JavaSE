import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int count = 0;
            while (n / 5 != 0) {
                count++;
                n /= 5;
            }
            System.out.println(count);
        }
    }
}


class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            StringBuffer buffer = new StringBuffer(String.valueOf(n));
            buffer = buffer.reverse();
            System.out.println(Integer.parseInt(buffer.toString()));
        }
    }
}