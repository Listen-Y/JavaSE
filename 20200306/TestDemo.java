/*public class TestDemo {

	public static void main(String[] args) {

		int i = 9;

		int count = 0;

		while(i<100) {

       count++;

       i = i+10;

		}

		System.out.println(count);

	}

}*/
/*public class TestDemo {

	public static void main(String[] args) {

		int year = 0;

		for(year = 1000; year <=2000; year++) {

			if((year%4 == 0) && (year%100 != 0)) {

				System.out.print(" "+year);

			}else if(year%400 == 0) {

        System.out.print(" "+year);

			}

		}

	}

}
*/
/*public class TestDemo {
	public static void main(String[] args) {
		int num = 2;
		boolean key = true;
		while(num<=100) {
			key = true;
			for(int i = 2; i < num; i++) {
				if(num%i == 0) {
					key = false;
                    break; 
                    }
				}
				if(key) {
					System.out.print(" " + num);
				}
				num++;
			}
	}
}*/

/*import java.util.Scanner;
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		boolean key = true;
			for(int i = 2; i < num; i++) {
		      if(num%i == 0) {
			     key = false;
                 break; 
                }
            }
                if(key) {
                	System.out.println(num+"not");
                } else {
                	System.out.print(num + "is");
                }
         scan.close();
	}
}
*/
/*import java.util.Scanner;
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		if(age<=18) {
			System.out.print("少年");
		} else if(age<=28) {
			System.out.print("青年");
		} else if(age<=55) {
			System.out.print("中年");
		} else {
			System.out.print("老年");
		}

	}
}*/
/*import java.util.Scanner;
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = num-1; i > 1; i--) {
			if(num%i == 0) {
				System.out.print(i);
				break;
			}
		}
	}
}*/
/*import java.util.Scanner;
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int count = 0;
		while(num != 0) {
			if((num&1) == 1) {
				count++;
			}
			num = num>>1;
		}
		System.out.print(count);
	}
}*/

/*public class TestDemo {
	public static void main(String[] args) {
		double ret = 0;
		for(int i = 1; i <= 100; i ++ ) {
			if(i%2 == 0) {
				ret = ret - (1.0/i);
			}else {
				ret = ret + (1.0/i);
			}
		}
		System.out.print(ret);
	}
}*/

/*import java.util.Scanner;
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		if(age<=18) {
			System.out.print("少年");
		} else if(age<=28) {
			System.out.print("青年");
		} else if(age<=55) {
			System.out.print("中年");
		} else {
			System.out.print("老年");
		}

	}
}*/

/*import java.util.Scanner;
 public class TestDemo {
 	public static void main(String[] args) {
 		Scanner scan = new Scanner(System.in);
 		while(scan.hasNext()) {
 			int num = scan.nextInt();
 			System.out.println("整数 " + num);	
 		}
 	}
 }
*/
 /*import java.util.Scanner;

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
 }*/

 /*import java.util.Scanner;
 public  class TestDemo {
 	public static void main(String[] args) {
 		Scanner scan = new Scanner(System.in);
 		int count = 3;
 		//System.out.print(passwarld); 
 		while(count>0) {
 			System.out.print("输入密码:>");
 			String passwarld = scan.next();
 			if(passwarld.equals("李星亚")) {
 				System.out.println("登录成功！！");
 				break;
 			}else {
 				count --;
 				System.out.println("输入错误，你还有" + count + "次机会！！");
 			}

 		}
 	}
 }*/

 /*import java.util.Scanner;
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
 }*/

 import  java.lang.Math;
 public class TestDemo {
 	public static void main(String[] args) {
 		judgeNum();
 	}

 	public static void judgeNum() {
 		int ret_count = 0;
 	    int ret_num = 0;
 	    int num = 0;
 	    int sum = 0;
 	        for(num = 1; num <= 100000; num ++) {
 	        	    ret_count = numPart_count(num);
 	        	        sum = (int)numPatr_pow(num, ret_count);
 	        	    if(sum == num) {
 	        		    System.out.print(" " + num);
 	        	    }
 	        }
 	}

 	public static int numPart_count(int num) {
 		int count = 0;
 		    while(num != 0) {
 			    num = num / 10;
 			        count ++;
 		    }
 		return count;
 	}

 	public static int numPatr(int num) {
 		return num % 10;
 	}

 	public static double numPatr_pow(int num, int ret_count) {
 		if(num == 0) {
 			return 0;
 		}else {
 			return Math.pow(numPatr(num), ret_count) + numPatr_pow(num / 10, ret_count);
 		}
 	}
 }
