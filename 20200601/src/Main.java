import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int bottles = scan.nextInt();
            int count = 0;
            while (bottles >= 3) {
                int drink= bottles / 3;
                bottles = drink + bottles % 3;
                count += drink;
            }
            if (bottles == 2) {
                count++;
            }
            System.out.println(count);
        }
    }
}