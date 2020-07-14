public class TestQueue {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();

        Thread producter = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    try {
                        queue.put(i);
                        System.out.println("生产了" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        producter.start();

        Thread consumer = new Thread() {
            @Override
            public void run() {

                while (true) {
                    try {
                        int ret = queue.take();
                        System.out.println("消费" + ret);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        consumer.start();

    }
}
