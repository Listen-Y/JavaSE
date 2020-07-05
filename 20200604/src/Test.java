import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int n = scan.nextByte();
        //ptintStar(n);
        fun();
    }

    private static void ptintStar(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            builder.append('/');
        }
        for (int i = 0; i < n; i++) {
            builder.append('*');
        }
        while (builder.length() > n) {
            System.out.println(builder.toString());
            builder.deleteCharAt(builder.length() - 1);
        }
        System.out.println(builder.toString());
        for (int i = n - 1; i >= 0; i--) {
            builder.setCharAt(i, '*');
            System.out.println(builder.toString());
        }
    }

    public static void fun() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + j * i + "  ");
            }
            System.out.println();
        }
    }
}
