public class ThreadTest2 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {
                    System.out.println("t 开始运行");
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" t 运行结束");
                }
            }
        };
        t.start();
    }
}
