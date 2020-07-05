import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Scanner;

public class DayTest {
    static  int i;
    public static void main(String[] args) {
        System.out.println(i);
        //输出为0
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(s);
    }
}

class Main1 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int apples = scan.nextInt();
            int ret = buyNums(apples);
            System.out.println(ret);
        }
    }
    private static int buyNums(int apples) {
        for (int i = apples / 8; i >= 0; i--) {
            if ((apples - 8 * i) % 6 == 0) {
                return i + (apples - 8 * i) / 6;
            }
        }
        return -1;
    }
}
