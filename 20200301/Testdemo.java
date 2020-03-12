import java.util.Scanner;
 import java.util.Random;

 public class TestDemo {
 	public static void main(String[] args) {
 		Scanner scan = new Scanner(System.in);
 		Random random = new Random();
 		int key = random.nextInt(100);
 		int input = 0;
 		do {
 			System.out.print("输入你猜的数字:>");
 			  input = scan.nextInt();
 			    if(input<key) {
 			    	System.out.println("猜小了！！");
 			    }else if(input >key) {
 			    	System.out.println("猜大了！！");
 			    }else {
 			    	System.out.println("恭喜你！！");
 			    	break;
 			    }
 		}while(true);
 		    System.out.print("游戏结束！！");
 	}
 }