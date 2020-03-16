import java.util.Scanner;

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

