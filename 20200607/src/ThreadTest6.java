public class ThreadTest6 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是张三");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("我是李四");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        thread.join();
        thread1.start();
    }
}
