/*

import java.util.Scanner;
public class Tses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println("有" + jumpNum2(input) + "种跳法");
    }
    //递归
    public static int jumpNum(int num) {
        if(num == 0) {
            return 0;
        }else if(num == 1) {
            return 1;
        }else if(num == 2) {
            return 2;
        } else {
            return jumpNum(num-1) + jumpNum(num-2);
        }
    }
    //迭代
    public static int jumpNum2(int num) {
        int k0 = 0;
        int k1 = 1;
        int k2 = 2;
        int result = 0;
        if(num == 0) {
            return k0;
        }else if(num == 1) {
            return k1;
        }else if(num == 2) {
            return k2;
        }else {
            for(int k = 3; k <= num; k ++) {
                result = k2 + k1;
                k1 = k2;
                k2 = result;
            }
            return result;
        }
    }
}
*/
import java.util.Scanner;
public class Tses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入盘子数目:>");
        int input = scan.nextInt();
        char A = 'A';
        char B = 'B';
        char C = 'C';
        hanio(input, A, B, C);
    }

    public static void hanio(int input, char A, char B, char C) {
        if(input == 1) {
            System.out.println("from " + A +" to " + C);
        }else {
            hanio(input-1, A, C, B);
            System.out.println ("from " + A +" to " + C);
            hanio(input-1, B, A, C);
        }
    }
}
