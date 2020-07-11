import java.util.Scanner;

public class ThreadTest5 {
    public static void main(String[] args) {
        Object lock = new Object();
        Object lock2 = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock.getClass()) {
                    System.out.println("请输入一个数字:");
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    System.out.println("num" + "=" + num);
                }
            }
        };

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock2.getClass()) {
                        System.out.println("我t1得到锁了");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t.start();
        t1.start();

    }
}
