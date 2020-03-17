/*public class Ways {
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		b = Compare(a,b);
		System.out.print(b);
	}

	public static int Compare(int a, int b) {
		b = a>b ? a : b;
		return b;
	}
}
*/
/*import java.lang.Math;
import java.util.Scanner;
public class Ways {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 int a = scan.nextInt();
		  int b = scan.nextInt();
		   int c = Math.max(a,b);
		     System.out.print(c);
	}
}
*/

/*import java.util.Scanner;

public  class Ways {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		    System.out.print("输入一个数字:>");
            num = scan.nextInt();
		    print_one(num);
		    System.out.println();
		    print_two(num);
	}

	public static void print_one(int num) {
		int i = 0;
		int count = 0;
		while(count <16) {
			i = num&1;
			System.out.print(" " + i);
			num = num>>>2; 
			count ++;
		}
	}

	public static void print_two(int num) {
		int i = 0;
		int count = 0;
		num = num>>>1;
		while(count <16) {
			i = num&1;
			System.out.print(" " + i);
			num = num>>>2;
			count ++;
		}
	}
}
*/

import java.util.Scanner;
public class Ways {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int ret = 0;
		while(num > 0) {
		ret = numPart(num);
		num /= 10;
		    System.out.print(" " + ret);
		}
	}

	public static int numPart(int num) {
 		return num % 10;
 	}
}