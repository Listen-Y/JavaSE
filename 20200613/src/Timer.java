import java.util.concurrent.PriorityBlockingQueue;

public class Timer {

    //添加一个公共用对象去实现wait和唤醒
    private final Object loker = new Object();
    //首先需要一个类Task去描述一个任务
    //使用阻塞优先级队列来组织若干个线程判断谁先执行
    private PriorityBlockingQueue<Task> blockingQueue = new PriorityBlockingQueue<>();

    //用一个线程去循环扫描当前队列的队首元素 如果时间到了就执行该任务
    public Timer() {
        Worker worker = new Worker(blockingQueue, loker);
        //启动worker里的线程
        worker.start();
    }

    //计时器还需要一个方法让用户往里放任务
    public void schedule(Runnable runnable, long time) {
        Task task = new Task(runnable, time);
        blockingQueue.put(task);

        //新进来任务要唤醒wait的线程让优先级队列重新组织去判断哪个先执行
        synchronized (loker) {
            loker.notify();
        }
    }
}


//因为要放到优先级阻塞队列所有要实现Compararble接口
class Task implements Comparable<Task> {
    //在这类去描述一个线程任务 所以他需要你个Runnable和time去确定什么时候执行
    private Runnable runnable;
    private long time;

    public Task(Runnable runnable, long after) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + after;
    }

    //提供一个run方法执行Runnable
    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(Task o) {
        //要让时间小的先去执行
        return (int) (this.time - o.time);
    }
}

//执行任务的一个类
class Worker extends Thread {

    //要接收计时器传来的阻塞优先级队列
    private PriorityBlockingQueue<Task> blockingQueue;
    private final Object loker;

    public Worker(PriorityBlockingQueue<Task> blockingQueue, Object loker) {
        this.blockingQueue = blockingQueue;
        this.loker = loker;
    }

    @Override
    public void run() {

        //循环扫描 如果时间到了就执行任务 时间未到就等待
        while (true) {
            try {
                Task task = blockingQueue.take();
                long curTime = System.currentTimeMillis();
                if (task.getTime() > curTime) {
                    //时间未到继续等待
                    blockingQueue.put(task);

                    //为了避免忙等我们使用wait来提高效率 但是在等待过程中如果又加进来优先级更高的任务 就要先执行那个任务 所以就需要换醒这个线程
                    synchronized (loker) {
                        loker.wait(task.getTime() - curTime);
                    }
                } else {
                    //时间到了执行任务
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
