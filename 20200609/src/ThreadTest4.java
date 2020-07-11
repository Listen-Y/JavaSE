public class ThreadTest4 {
    static class Test {
        synchronized public static void methon() {
            System.out.println("haha");
        }
    }

    public static void main(String[] args) {
        //Test test = new Test();
        Thread thread = new Thread() {
            @Override
            public void run() {
                Test.methon();
            }
        };
        thread.start();
    }
}
