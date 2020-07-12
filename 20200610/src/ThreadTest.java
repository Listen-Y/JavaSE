public class ThreadTest {
    static class Count {
        public volatile int count = 0;

        public void increase() {
            count++;
        }
    }

    public static void main(String[] args) {
        Count count = new Count();
        Thread t = new Thread() {
            @Override
            public void run() {
                while (count.count == 0) {

                }
                System.out.println("线程t执行完毕");
            }
        };

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("进行count++");
                count.increase();
            }
        };

        t.start();
        t1.start();

    }
}
