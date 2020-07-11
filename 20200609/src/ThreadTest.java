public class ThreadTest {
    static class Count {

        public int count = 0;

        synchronized public void increase() {
            count++;
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    count.increase();
                }
            }
        };

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    count.increase();
                }
            }
        };

        t.start();
        t1.start();
        t.join();
        t1.join();
        System.out.println(count.count);
    }
}
