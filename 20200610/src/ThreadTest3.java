public class ThreadTest3 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t = new Thread() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (locker) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" t 开始运行");
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

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {
                    System.out.println(" t1 开始运行");
                    locker.notify();
                    System.out.println(" t1 运行结束");
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {
                    System.out.println(" t2 开始运行");
                    System.out.println(" t2 运行结束");
                }
            }
        };
        t2.start();
    }
}
