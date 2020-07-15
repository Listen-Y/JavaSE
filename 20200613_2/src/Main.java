import sun.security.krb5.SCDynamicStoreConfig;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //add();
        BigIntegerTest();

    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextByte();
            int n1 = scanner.nextByte();

            n = n + n1;
            n1 = n - n1;
            n = n - n1;

            n = n ^ n1;
            n1 = n ^ n1;
            n = n ^ n1;

            System.out.println(n + " " + n1);
        }
    }

    public static void KindCount() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String[] ss = s.split(" ");

            Set<String> set = new HashSet<>();

            Collections.addAll(set, ss);

            System.out.println(set.size());
        }
    }

    public static void BigIntegerTest() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            BigInteger bigInteger = new BigInteger(scanner.nextLine());
            BigInteger bigInteger1 = new BigInteger(scanner.nextLine());

            System.out.println(bigInteger.add(bigInteger1));
            System.out.println(bigInteger.subtract(bigInteger1));
            System.out.println(bigInteger.multiply(bigInteger1));
            System.out.println(bigInteger.divide(bigInteger1));
        }
    }
}
