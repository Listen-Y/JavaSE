import java.util.Scanner;

public class ThreadTest6 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("输入一个数");
                    Scanner s = new Scanner(System.in);
                    int num = s.nextInt();
                    System.out.println(num);

                    synchronized (lock) {
                        System.out.println("输入一个数");
                        int num1 = s.nextInt();
                        System.out.println(num1);
                    }
                }
            }
        };
        t.start();

    }
}
