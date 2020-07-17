public class Test {

     String s;

    public static void main1(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Im coming");
                timer.schedule(this, 1200);
            }
        }, 1500);
    }

    public static void main2(String[] args) {
        int i = 0;
        Integer integer = new Integer(0);

        System.out.println(i == integer);
        System.out.println(integer.equals(i));

    }

    public static void main3(String[] args) {

        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;

        b6 = b4 + b5;

        //b3 = b1 + b2;
    }

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        thread.start();
        System.out.println("ping");
    }

    private static void pong() {
        System.out.print("pong");
    }
}
