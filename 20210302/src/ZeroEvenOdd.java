import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 总结： 在多线程题目下， 如果要让其终止， 可以在上锁外面加一个for循环， 让那个这个循环结束
 * 那么这个线程也就结束了
 */
public class ZeroEvenOdd {
    private int n;
    private volatile int state = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (state != 0) {
                zero.await();
            }
            printNumber.accept(0);

            if (i % 2 == 0) {
                state = 1;
                odd.signalAll();
            } else {
                state = 2;
                even.signalAll();
            }
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            while (state != 2) {
                even.await();
            }
            state = 0;
            printNumber.accept(i);
            zero.signalAll();
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i+= 2) {
             lock.lock();
             while (state != 1) {
                 odd.await();
             }
             state = 0;
             printNumber.accept(i);
             zero.signalAll();
             lock.unlock();
        }
    }
}