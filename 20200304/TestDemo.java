public class TestDemo {
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
}