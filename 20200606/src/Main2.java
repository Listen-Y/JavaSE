import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] strs = str.split(" ");
            int num1 = Integer.parseInt(strs[0]);
            int num2 = Integer.parseInt(strs[1]);
            int key = Math.max(num1, num2) + 1;
            while (key % num1 != 0 || key % num2 != 0) {
                key++;
            }
            System.out.println(key);
        }
    }
}