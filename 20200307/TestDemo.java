import java.util.Scanner;

 public class TestDemo {
 	public static void main(String[] args) {
 		Scanner scan = new Scanner(System.in);
 		int num1 = scan.nextInt();
 		int num2 = scan.nextInt();
 		int yuShu = num1 % num2;
 		while(yuShu != 0) {
 			num1 = num2;
 			num2 = yuShu;
 			yuShu = num1 % num2;
 		}
 		System.out.print(num2);
 	}
 }