public class ThreadTest3 {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("listen") {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println(Thread.currentThread().getName() + "在忙着打游戏");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("赶快走!!!");
            }
        };
        thread.start();
        Thread.sleep(5000);
        System.out.println(thread.getName() + "你女朋友来电话让你逛街");
        isQuit = true;
    }
}
