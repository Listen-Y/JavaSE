public class ThreadTest3 {
    static class Test {
        private final Object o = new Object();

        public void method() {
            synchronized (o) {
                System.out.println("haha");
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.method();
    }
}
