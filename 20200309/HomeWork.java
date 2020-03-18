/*import java.util.Scanner;
public class HomeWork {
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
}*/

/*import java.util.Scanner;
public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入你要求的n>");
		int input = scan.nextInt();
		int ret = function(input);
		System.out.print(ret);

	}

	public static int function(int num) {
		int i = 1;
		int sum = 0;
		int j = 1;
		 do {
	    	j=j*i;
	    	sum+=j;
	    	i++;

	    }while(i <= num);
	    return sum;
	}
}*/

/*import java.util.Scanner;
public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入你要求的n:>");
		int input = scan.nextInt();
		int ret = function(input);
		System.out.print(ret);
	}

	public static int function(int num) {
		if(num == 1) {
			return 1;
		}else {
			return num * function(num-1);
		}
	}
}*/

/*import java.lang.Math;
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
}*/

import java.util.Scanner;
public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入数:>");
		float a = scan.nextFloat();
		float b = scan.nextFloat();
		int c = scan.nextInt();
		float ret = add(a, b, c);
		System.out.print(ret);

	}

	public static int add(int a, int b) {
		return a>b ? a : b;
	}

	public static float add(float a, float b) {
		return a>b ? a : b;
	}

	public static float add(float a, float b, int c) {
		return add(a, b)>c ? add(a, b) : c;
	}
}
/*import java.util.Scanner;
public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		add();
		add();
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(float a, float b, float c) {
		return a + b + c;
	}
}
*/