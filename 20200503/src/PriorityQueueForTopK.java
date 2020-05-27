public class PriorityQueueForTopK {
    private int[] array;
    private int size;
    //构造k个位置
    public PriorityQueueForTopK(int k) {
        this.array = new int[k];
    }
    //入队列
    public void offer(int data) {
        if(size < array.length) {
            array[size] = data;
            smallShiftUp(size);
            size ++;
        }else {
            compareOfferFirst(data);
        }
    }
    //向上调整建小堆
    private void smallShiftUp(int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(this.array[parent] > this.array[child]) {
                int tmp = this.array[child];
                this.array[child] = this.array[parent];
                this.array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    //与队首进行比较入队列
    private void compareOfferFirst(int data) {
        if(data > this.array[0]) {
            this.array[0] = data;
            smallShiftDown(0);
        }
    }
    //向下调整建小堆
    private void smallShiftDown(int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child] > array[child + 1]) {
                child ++;
            }
            if(array[child] < array[parent]) {
                int tmp = this.array[child];
                this.array[child] = this.array[parent];
                this.array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    //出队列
    public Integer poll() {
        if(size == 0) {
            return null;
        }
        int ret = this.array[0];
        System.arraycopy(this.array, 1, this.array, 0, array.length - 1);
        size --;
        return ret;
    }
    //查看队首元素
    public Integer peek() {
        if(this.size == 0) {
            return null;
        }
        return this.array[0];
    }
    //判空
    public boolean empty() {
        return this.size == 0;
    }

}
