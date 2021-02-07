import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-26
 * Time: 19:16
 */
public class Main {
    public static void main(String[] args){
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Store store = new Store();;
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                if (store.num != 0)
                store.A(i++);
                if (store.num != 0)
                store.B(i++);
                if (store.num != 0)
                store.C(i++);
                if (i >= 19) {
                    i = 0;
                }
                if (store.num == 0) {
                    break;
                }
            }
        }).start();
    }

}

class Store {

    private final Object lock = new Object();
    public volatile int num = 100;

    public void A(int people) {
        synchronized (lock) {

            System.out.println(num + " 被A卖了" + people + "买了");
            try {
                Thread.sleep(5);
            } catch (Exception ignored) {

            }

            num--;
            if (num != 0) {
                lock.notifyAll();
            }

        }
    }

    public void B(int people) {
        synchronized (lock) {

            System.out.println(num + " 被B卖了" + people + "买了");
            try {
                Thread.sleep(5);
            } catch (Exception ignored) {

            }
            num--;
            if (num != 0) {
                lock.notifyAll();
            }
        }
    }

    public void C(int people) {
        synchronized (lock) {

            System.out.println(num + " 被C卖了" + people + "买了");
            try {
                Thread.sleep(5);
            } catch (Exception ignored) {

            }
            num--;
            if (num != 0) {
                lock.notifyAll();
            }
        }
    }
}
