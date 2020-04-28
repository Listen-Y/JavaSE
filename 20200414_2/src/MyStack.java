/**
 * Stack
 */
//顺序表
public class MyStack {
    private int[] arrar = new int[100];
    private int size = 0;

    public void push(int value) {
        arrar[size] = value;
        size ++;
    }

    public Integer pop() {
        if(size <= 0) {
            return null;
            //throw new ArrayIndexOutOfBoundsException();
        }
        int ret = arrar[size - 1];
        size --;
        return ret;
    }
    public Integer peek() {
        if(size <= 0) {
            return null;
        }
        return arrar[size - 1];
    }

}
//链表
class MyStack2 {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;

    public void push(int value) {
        Node find = new Node(value);
        if(this.head == null) {
            this.head = find;
            return;
        }
        find.next = this.head;
        this.head = find;
    }

    public Integer pop() {
        if(this.head == null) {
            return null;
        }
        Node find = this.head;
        this.head = this.head.next;
        return find.val;
    }

    public Integer peek() {
        if(this.head == null) {
            return null;
        }
        return this.head.val;
    }

}
