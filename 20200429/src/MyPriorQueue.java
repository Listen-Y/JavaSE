import javax.accessibility.AccessibleHyperlink;

public class MyPriorQueue {
    private int[] array = new int[100];
    private  int size = 0;

    public void offer(int data) {
        this.array[size] = data;
        size ++;
        shiftUp(array, size, size - 1);
    }

    private void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1)/2;
        while (child > 0) {
            if(array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }else  {
                break;
            }
            child = parent;
            parent = (child - 1)/2;
        }
    }

    public Integer poll() {
        if(size <= 0) {
            return null;
        }
        int ret = this.array[0];
        this.array[0] = this.array[size - 1];
        size --;
        shiftDown(array, size, 0);
        return ret;
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && array[child] < array[child + 1]) {
                child += 1;
            }
            if(array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }else  {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public Integer peek() {
        if(size <= 0) {
            return null;
        }
        return array[0];
    }

    public boolean empty() {
        return size == 0;
    }

   /* public void display() {
        for (int i:this.array
             ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }*/

    public int length() {
        return size;
    }
}
