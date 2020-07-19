import java.math.BigInteger;
import java.util.Scanner;

class Main1 {

    public static void main1(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            int n = Integer.parseInt(strings[0]);
            char ch = strings[1].charAt(0);

            for (int i = 0; i < n; i++) {
                System.out.print(ch);
            }
            System.out.println();

            int col = (int) Math.round(n * 0.5) - 2;

            for (int i = 0; i < col; i++) {
                System.out.print(ch);
                for (int j = 0; j < n - 2; j++) {
                    System.out.print(" ");
                }
                System.out.println(ch);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

class Main2 {
    public static void main2(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        String C = scanner.next();

        double row=Math.ceil((double)N/2);

        for (double i=1.0;i<=row;i++){
            if (i==1.0||i==row){
                for (int j=1;j<=N;j++){
                    System.out.print(C);
                }
                System.out.println();
            }else {
                for (int j=1;j<=N;j++){
                    if (j==1||j==N){
                        System.out.print(C);
                    }else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String addend = scanner.nextLine();
            String augend = scanner.nextLine();

            BigInteger bigInteger = new BigInteger(addend);
            BigInteger bigInteger1 = new BigInteger(augend);
            System.out.println(bigInteger.add(bigInteger1).toString());
        }
    }
}
