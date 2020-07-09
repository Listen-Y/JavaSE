public class ThreadTest4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("listen") {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "在打游戏");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //因为在sleep中中断也会清除中断标记,所以要用break结束循环
                        break;
                    }
                }
                System.out.println("赶快去!!!");
            }
        };
        thread.start();
        Thread.sleep(5000);
        System.out.println(thread.getName() + "女朋友叫你去逛街");
        thread.interrupt();
    }
}
