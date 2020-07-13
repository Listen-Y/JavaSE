import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Tset {
    public static void main(String[] args) {


        /*BigInteger bigNum = new BigInteger("123456789865465434567654343456543");
        BigInteger bigNum2 = new BigInteger("1234567898765432345");
        BigInteger bigNum3 = new BigInteger("2");
        System.out.println(bigNum.multiply(bigNum2).add(bigNum3));*/
        //bigNumDivi();
        bigNumDiviRem();
    }

    public static void bigNumMUltiply() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(s);
            for (int i = Integer.parseInt(s) - 1; i >= 1; i--) {
                bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
            }
            System.out.println(bigInteger);
        }
    }

    public static void bigNumAdd() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(s);
            BigInteger bigInteger1 = new BigInteger(s1);
            bigInteger = bigInteger.add(bigInteger1);
            System.out.println(bigInteger);
        }
    }

    public static void bigNumSub() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(s);
            BigInteger bigInteger1 = new BigInteger(s1);
            bigInteger = bigInteger.subtract(bigInteger1);
            System.out.println(bigInteger);
        }
    }

    public static void bigNumDivi() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(s);
            BigInteger bigInteger1 = new BigInteger(s1);
            bigInteger = bigInteger.divide(bigInteger1);
            System.out.println(bigInteger);
        }
    }

    public static void bigNumDiviRem() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(s);
            BigInteger bigInteger1 = new BigInteger(s1);

            BigInteger[] result = bigInteger.divideAndRemainder(bigInteger1);
            System.out.println(result[0] + "." + result[1]);
        }
    }
}
