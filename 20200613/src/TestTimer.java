public class TestTimer {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
                timer.schedule(this, 2000);
            }
        }, 2000);
    }
}
