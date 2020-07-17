import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class MyThreadPool {

    //需要一个阻塞队列组织所有任务
    //还需要一个链表放置所有线程
    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>();
    private List<WorkerIng> list = new ArrayList<>();

    private static final int MaxWorkerIngCount = 10;

    //实现execute方法
    public void execute(Runnable runnable) throws InterruptedException {
        // 也是使用延时加载的方式来创建线程.
        // 当线程池中的线程数目比较少的时候, 新创建线程来作为工作线程.
        // 如果线程数目已经比较多了(达到设定的阈值), 就不用新建线程了.
        if (list.size() < MaxWorkerIngCount) {
            WorkerIng workerIng = new WorkerIng(this.blockingQueue, list.size());
            workerIng.start();
            list.add(workerIng);
        }

        blockingQueue.put(runnable);
    }

    //实现shutdown方法
    public void shutdown() throws InterruptedException {

        //遍历链表将所有线程都打断
        for (WorkerIng w : list
                ) {
            w.interrupt();
        }

        //等所有线程执行完毕再结束该线程
        for (WorkerIng w : list
             ) {
            w.join();
        }
    }

}

//一个工作类 执行优先级队列里的任务
class WorkerIng extends Thread {

    private BlockingQueue<Runnable> blockingQueue;
    private int id;

    public WorkerIng(BlockingQueue<Runnable> blockingQueue, int id) {
        this.blockingQueue = blockingQueue;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            while (! Thread.currentThread().isInterrupted()) {
                Runnable runnable = blockingQueue.take();
                System.out.println("线程" + id + "正在运行");
                runnable.run();
            }
        } catch (InterruptedException e) {
            System.out.println(id + " 线程结束");
        }
    }
}
