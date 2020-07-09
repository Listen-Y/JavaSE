public class ThreadTest2 {
    public static void main(String[] args) {
        Thread thread = new Thread("listen") {
            @Override
            public void run() {
               //死循环让该线程一直执行
                while (true) {

                }
            }
        };
        thread.start();
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getState());
        System.out.println(thread.getPriority());
        System.out.println(thread.isDaemon());
        System.out.println(thread.isAlive());
        System.out.println(thread.isInterrupted());
    }
}
