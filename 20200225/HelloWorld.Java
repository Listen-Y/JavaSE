

public class HelloWorld {
	public static void main (String[] args) {
		int num1=3;
		int num2=5;
		int num3=7;
		num2=(num1>num2)? num1:num2;
		num2=(num2>num3)? num2:num3;
		System.out.println(num2); 
		//System.out.println("Hello Java");
	}
} 