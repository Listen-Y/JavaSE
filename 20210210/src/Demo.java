import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-02-10
 * Time: 9:21
 */
public class Demo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    }

    /**
     * 矩阵中最长路径的长度
     */
    int[][] next = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int ans = 0;
    public int fun(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                dfs(nums, i, j, 0, Integer.MIN_VALUE);
            }
        }
        return ans;
    }

    public void dfs(int[][] nums, int x, int y, int length, int num) {
        if (nums[x][y] <= num) {
            return;
        }
        length++;
        ans = Math.max(ans, length);
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newy = y + next[i][1];
            if (newX < 0 || newX >= nums.length || newy < 0 || newy >= nums[0].length) {
                continue;
            }
            dfs(nums, newX, newy, length, nums[x][y]);
        }
    }

    /**
     * 单例模式
     */
    private static Object obj = new Object();

    public static Object get() {
        return obj;
    }

    private static Object obj2;

    public static Object get1() {

        if (obj2 == null) {
            synchronized(obj2) {
                if (obj2 == null) {
                    obj2 = new Object();
                }
            }
        }
        return obj2;
    }

    /**
     * 三个线程轮番打印
     */
    private Object lock = new Object();
    private volatile int key = 1;

    public void A() throws InterruptedException {
        synchronized(lock) {
            while (key != 1) {
                lock.wait();
            }
            System.out.println("1");
            key = 2;
            lock.notifyAll();
        }
    }

    public void B() throws InterruptedException {
        synchronized(lock) {
            while (key != 2) {
                lock.wait();
            }
            System.out.println("2");
            key = 3;
            lock.notifyAll();
        }
    }

    public void C() throws InterruptedException {
        synchronized(lock) {
            while (key != 3) {
                lock.wait();
            }
            System.out.println("3");
            key = 1;
            lock.notifyAll();
        }
    }
}
