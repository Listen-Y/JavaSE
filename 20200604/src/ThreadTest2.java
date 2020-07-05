public class ThreadTest2 {
    private static long count = 10_0000_0000;
    public static void main(String[] args) {
        Danxianc();
        Duoxianc();
    }

    private static void Danxianc() {
        long beg = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int a;
            a = i;
        }
        for (int i = 0; i < count; i++) {
            int b;
            b = i;
        }
        System.out.println(System.currentTimeMillis() - beg + "ms");
    }

    private static void Duoxianc() {
        long beg = System.currentTimeMillis();
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    int a;
                    a = i;
                }
            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    int b;
                    b = i;
                }
            }
        };
        thread.start();
        thread1.start();
        //让方法这个线程等待,等thread 和thread1这两线程跑完自己再执行
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - beg + "ms");
    }
}
