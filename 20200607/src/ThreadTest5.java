public class ThreadTest5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("listen") {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    //会清除中断标记
                    System.out.println(Thread.currentThread().getName() + "在打游戏");
                }
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("赶快去!!!");
                }
            }
        };
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getName() + "女朋友叫你去逛街");
        thread.interrupt();
    }
}
