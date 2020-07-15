import java.util.concurrent.PriorityBlockingQueue;

//需要一个描述任务的类
//而且要实现一个比较接口 方便其在优先级队列组织
class Task implements Comparable<Task> {

    //类里要有执行方式 和执行的时间
    private Runnable runnable;
    private long time;

    public Task(Runnable runnable, long after) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + after;
    }

    //一个执行Runnable的方法
    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(Task o) {
        return (int) (this.time - o.time);
    }
}

//需要一个worker类去执行任务
class Worker extends Thread {

    //属性有传过来的那个优先级队列和一把锁
    private PriorityBlockingQueue<Task> blockingQueue;
    private final Object loker;

    public Worker(PriorityBlockingQueue<Task> blockingQueue, Object loker) {
        this.blockingQueue = blockingQueue;
        this.loker = loker;
    }

    @Override
    public void run() {

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

public class Timer {

    //需要一个对象锁去保证线程安全 提高执行效率
    private final Object loker = new Object();

    //需要一个阻塞优先级队列 去组织多个任务判断哪个先执行
    private PriorityBlockingQueue<Task> blockingQueue = new PriorityBlockingQueue<>();

    //在构造方法里去执行队列里的任务
    public Timer() {
        Worker worker = new Worker(this.blockingQueue, this.loker);
        worker.start();
    }

    //计时器里还需要一个方法方便用户往里添加任务
    public void schedule(Runnable runnable, long time) {

        blockingQueue.put(new Task(runnable, time));
        //新添加进元素要唤醒等待的线程 让优先级队列重新区组织 然后执行优先级最高的那个任务
        synchronized (loker) {
            loker.notify();
        }
    }
}
