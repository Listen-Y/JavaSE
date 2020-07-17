
import java.util.concurrent.PriorityBlockingQueue;

public class Timer {

    //需要一个阻塞优先级队列里面放的是一个Task任务和一个对象锁
    private PriorityBlockingQueue<Task> blockingQueue = new PriorityBlockingQueue<>();
    private final Object loker = new Object();

    //在构造函数里就去执行优先级队列里的任务
    public Timer() {

        Worker worker = new Worker(blockingQueue, loker);
        worker.start();
    }

    //提供一个方法为用户添加任务
    public void schedule(Runnable runnable, long after) {
        Task task = new Task(runnable, after);
        blockingQueue.put(task);

        synchronized (loker) {
            loker.notify();
        }
    }
}

class Task implements Comparable<Task> {

    //描述一个执行的任务 需要有如和执行的值和一个时间
    private Runnable runnable;
    private long time;

    public Task(Runnable runnable, long after) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + after;
    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Task o) {
        return (int) (this.time - o.time);
    }
}

class Worker extends Thread {

    private PriorityBlockingQueue<Task> blockingQueue;
    private final Object loker;

    public Worker(PriorityBlockingQueue<Task> blockingQueue, Object loker) {
        this.blockingQueue = blockingQueue;
        this.loker = loker;
    }

    @Override
    public void run() {
        //循环扫描执行任务
        while (true) {

            try {
                Task task = blockingQueue.take();
                long curTime = System.currentTimeMillis();
                if (task.getTime() > curTime) {
                    blockingQueue.put(task);

                    synchronized (loker) {
                        loker.wait(task.getTime() - curTime);
                    }
                } else {
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}