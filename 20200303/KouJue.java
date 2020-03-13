import java.util.Scanner;
public class KouJue {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int i=0;
		int j=0;
		//for
		for(i=1;i<=n;i++){
			for(j=1;j<=i;j++){
				System.out.print(" "+j+'*'+i+'='+i*j);
			}
			System.out.println();
		}
		//while
		i=j=1;
		while(i<10) {
			j=1;
			while(j<=i) {
				System.out.print(" "+j+'*'+i+'='+i*j);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}