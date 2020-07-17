public class MyThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        MyThreadPool myThreadPool = new MyThreadPool();
        int[] nums = new int[]{1};

        for (int i = 0; i < 1000; i++) {
            myThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是一个线程, id 为" + nums[0]++);
                }
            });
        }

        Thread.sleep(2000);
        myThreadPool.shutdown();
        System.out.println("都被打断了");
    }
}
