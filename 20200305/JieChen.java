import java.util.Scanner;

public class JieChen {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int sum=0;
		int ret=1;
	    int i=1;
	    do {
	    	ret=ret*i;
	    	sum+=ret;
	    	i++;

	    }while(i<=input);
	    System.out.println(sum);
	    scan.close();
	}
}