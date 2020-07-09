public class ThreadTest7 {
    public static void main(String[] args) {
        for (Thread.State s : Thread.State.values()
             ) {
            System.out.println(s);
        }
    }
}
