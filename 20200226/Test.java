import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入你要的第n项:>");
		int input = scan.nextInt();
		int ret = fib(input);
		System.out.print(ret);
	}

	public static int fib(int num) {
		if(num == 1 ||num == 2) {
			return 1;
		}else {
			return fib(num-1) + fib(num-2);
		}
	}
}