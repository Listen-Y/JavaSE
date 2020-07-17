public class MyPool2Test {

    public static void main(String[] args) throws InterruptedException {

        MyThreadPool2 myThreadPool2 = new MyThreadPool2();

        for (int i = 1; i <= 1000; i++) {
            myThreadPool2.exceluct(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是一个任务");
                }
            });
        }

        Thread.sleep(2000);
        myThreadPool2.shutdown();
        System.out.println("ALL OVER");
    }
}
