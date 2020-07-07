import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            for (String s : strings
                 ) {
                int num = Integer.parseInt(s);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e : map.entrySet()
                 ) {
                if (e.getValue() >= strings.length / 2) {
                    System.out.print(e.getKey() + " ");
                }
            }
            System.out.println();
        }
    }
}



class Main1 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            byte a_b = scan.nextByte();
            byte b_c = scan.nextByte();
            byte aAddb = scan.nextByte();
            byte bAddc = scan.nextByte();
            byte a = (byte) ((a_b + aAddb) / 2);
            byte b = (byte) (aAddb - a);
            byte c = (byte) (bAddc - b);
            if ((a_b + aAddb) % 2 == 0 && a >= 0 && b >= 0 && c >= 0) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println("No");
            }
        }
    }
}