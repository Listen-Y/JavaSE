//阻塞队列

public class BlockingQueue {

    private int[] array = new int[20];
    private int haed = 0;
    private int tail = 0;
    private volatile int size = 0;

    //put向队列放元素
    public void put(int val) throws InterruptedException {

        synchronized (this) {

            while (this.size == array.length) {
                this.wait();
            }

            array[tail] = val;
            tail++;
            size++;
            if (tail == array.length) {
                this.tail = 0;
            }

            this.notify();
        }
    }

    //take取队首元素
    public int take() throws InterruptedException {

        int ret;
        synchronized (this) {

            while (this.size == 0) {
                this.wait();
            }

            ret = array[haed];
            haed++;
            size--;
            if (haed == array.length) {
                this.haed = 0;
            }

            this.notify();
        }

        return ret;
    }

}
