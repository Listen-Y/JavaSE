import java.util.Scanner;
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
 }