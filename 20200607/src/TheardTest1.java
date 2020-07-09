public class TheardTest1 {
    public static void main(String[] args) {
        Thread thread = new Thread("listen") {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        };
        //thread.run();
        thread.start();

    }
}
