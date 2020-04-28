/**
 * queue
 */
//链表
public class MyQueue {
    static class Node {
        public int vla;
        public Node next;

        public Node(int vla) {
            this.vla = vla;
        }
    }

    private Node haed = new Node(-1);
    private Node tail = haed;

    public void offer(int value) {
        tail.next = new Node(value);
        tail = tail.next;
    }

    public Integer poll() {
        Node delete = this.haed.next;
        if(delete == null) {
            this.tail = this.haed;
            return null;
        }
        this.haed.next = delete.next;
        return delete.vla;
    }

    public Integer peek() {
        if(this.haed.next == null) {
            return null;
        }
        return this.haed.next.vla;
    }
}
//顺序表
class MyQueue2 {
    private int[] array = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public boolean offer(int value) {
        if(size == array.length) {
            return false;
        }
        array[tail] = value;
        tail ++;
        if(tail >= array.length) {
            tail = 0;
        }
        //tail = tail % array.length;
        size ++;
        return true;
    }

    public Integer poll() {
        if(size == 0) {
            return null;
        }
        int ret = array[head];
        head ++;
        if(head >= array.length) {
            head = 0;
        }
        size --;
        return ret;
    }

    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[head];
    }
}
