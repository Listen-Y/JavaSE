public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.interrupted());
                }
            }
        };
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("================");
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };
        thread1.start();
        thread1.interrupt();
    }
}
