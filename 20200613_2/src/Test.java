public class Test {

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("a");

        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");

                if (!buffer.toString().equals("aaaa")) {

                    timer.schedule(this, 1000);
                    buffer.append("a");

                }
            }
        }, 1000);
    }
}
