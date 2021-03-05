import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 使用信号量机制可以完美解决
 * 主要俩个方法， 一个是acquire还有一个好似release
 * 最主要的还是要加一层for循环来终止线程
 */
class ZeroEvenOddBySem {
    private int n;

    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOddBySem(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                odd.release();
            } else {
                even.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}