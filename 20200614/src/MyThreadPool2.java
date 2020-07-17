import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool2 {

    //需要一个阻塞队列 还学要一个链表
    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>();
    private List<Worked> workedList = new ArrayList<>();

    //该线程池最大的线程数目
    private static final int MaxThreadCount = 10;

    //实现一个exceluct方法
    public void exceluct(Runnable runnable) throws InterruptedException {
        if (workedList.size() < MaxThreadCount) {
            Worked worked = new Worked(blockingQueue);
            worked.start();
            workedList.add(worked);
        }

        blockingQueue.put(runnable);
    }

    //实现一个shutdown方方法终止所有线程
    public void shutdown() throws InterruptedException {
        for (Worked w : workedList
             ) {
        w.interrupt();
        }

        for (Worked w: workedList
             ) {
            w.join();
        }
    }

}

//这是一个工作类
class Worked extends Thread {

    //有一个阻塞队列去接收线程池中的队列
    private BlockingQueue<Runnable> blockingQueue;

    public Worked(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable runnable = blockingQueue.take();
                System.out.println("线程执行任务中");
                runnable.run();
            } catch (InterruptedException e) {
                System.out.println("该线程被打断结束");
                break;
            }
        }
    }
}
