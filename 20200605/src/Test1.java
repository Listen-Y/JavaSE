import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if ((a + c) % 2 == 0 && (b + d) % 2 == 0 && (d - b) % 2 == 0) {
                int A = (a + c) % 2;
                int B = (b + d) % 2;
                int C = (d - b) % 2;
                if (A>= 0 && B >= 0 && C >= 0) {
                    System.out.println(A + " " + B + " " + C);
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }
}
