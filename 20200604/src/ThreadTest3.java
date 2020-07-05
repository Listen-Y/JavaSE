public class ThreadTest3 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello");
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("hello");
        }
    }
    public static void main(String[] args) {

        //1定义一个类继承Thread
        Thread t = new MyThread();
        t.start();

        //2定义匿名内部类
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t1.start();

        //3 lambda表达式
        Thread t2 = new Thread(() -> {
            System.out.println("hello");
        });
        t2.start();

        //4定义一个类继续Runnable接口,但注意要将runnable对象关联到Thread对象上
        Runnable r1 = new MyRunnable();
        Thread t3 = new Thread(r1);
        t3.start();

        //5匿名内部类继续Runnable接口
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Thread t4 = new Thread(r2);
        t4.start();

        //6对Runnable进行Lambda表达式
        Runnable r3 = () -> {
            System.out.println("hello");
        };
        Thread t5 = new Thread(r3);
        t5.start();

    }
}
