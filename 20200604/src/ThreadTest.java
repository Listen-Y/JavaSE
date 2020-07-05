public class ThreadTest {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}
