public class ThreadTest {
    static class Count {
        public static int count = 0;
        synchronized public static void increase() {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    Count.increase();
                }

            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    Count.increase();
                }
            }
        };
        thread.start();
        thread1.start();
        //Thread.sleep(1000);
        thread.join();
        thread1.join();
        System.out.println(Count.count);
    }
}
