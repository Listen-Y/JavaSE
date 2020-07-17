

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TeacterThreadPool {
    // 使用这个类来描述当前的工作线程是啥样的.
    static class Worker extends Thread {
        private int id = 0;
        // 每个 Worker 线程都需要从任务队列中取任务.
        // 需要能够获取到任务队列的实例
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            // 注意此处的 try 把 while 包裹进去了.
            // 目的是只要线程收到异常, 就会立刻结束 run 方法(也就是结束线程)
            try  {
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable command = queue.take();
                    System.out.println("thread " + id + " running...");
                    command.run();
                }
            } catch (InterruptedException e) {
                // 线程被结束.
                System.out.println("线程被终止");
            }
        }
    }

    // 本质上就是一个生产者消费者模型.
    // 调用 execute 的代码就是生产者. 生产了任务 (Runnable 对象)
    // worker 线程就是消费者. 消费了队列中的任务.
    // 交易场所就是 BlockingQueue
    static class MyThreadPool2 {
        // 这个阻塞队列用于组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        // 这个 List 用来组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();
        // 一个线程池内部应该有多少个线程, 需要根据实际情况来确定.
        // 当前写的 "10" 纯粹是拍脑门
        private static final int maxWorkerCount = 10;

        // 实现 execute 方法 和 shutdown 方法
        public void execute(Runnable command) throws InterruptedException {
            // 也是使用延时加载的方式来创建线程.
            // 当线程池中的线程数目比较少的时候, 新创建线程来作为工作线程.
            // 如果线程数目已经比较多了(达到设定的阈值), 就不用新建线程了.
            if (workers.size() < maxWorkerCount) {
                Worker worker = new Worker(queue, workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        // 当 shutdown 结束之后, 意味着所有的线程一定都结束了.
        public void shutdown() throws InterruptedException {
            // 终止掉所有的线程.
            for (Worker worker : workers) {
                worker.interrupt();
            }
            // 还需要等待每个线程执行结束.
            for (Worker worker : workers) {
                worker.join();
            }
        }
    }

    static class Command implements Runnable {
        private int num;
        public Command(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行任务: " + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool2 pool = new MyThreadPool2();
        for (int i = 0; i < 1000; i++) {
            pool.execute(new Command(i));
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程池已经被销毁");
    }
}
