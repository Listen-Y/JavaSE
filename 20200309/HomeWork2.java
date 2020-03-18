import java.lang.Math;
import java.util.Scanner;
public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入:>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int ret1 = compare_one(num1, num2);
		int ret2 = compare_two(num1, num2, num3);
		    System.out.println("前俩个数较大的是" + ret1);
		    System.out.print("最大的是" + ret2);
	}

	public static int compare_one(int a,int b) {
		return Math.max(a,b);
	}

	public static int compare_two(int a, int b ,int c) {
		return Math.max(compare_one(a, b), c);
	}
}