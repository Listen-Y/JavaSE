import java.util.*;

//用栈实现队列
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while( ! B.empty()) {
            Integer temp = B.pop();
            A.push(temp);
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(A.empty()) {
            return 0;
        }
        while(! A.empty()) {
            Integer temp = A.pop();
            B.push(temp);
        }
        int ret = B.pop();
        while(! B.empty()) {
            Integer temp2 = B.pop();
            A.push(temp2);
        }
        return ret;
    }

    /** Get the front element. */
    public int peek() {
        if(A.empty()) {
            return 0;
        }
        while(! A.empty()) {
            Integer temp = A.pop();
            B.push(temp);
        }
        int ret = B.peek();
        while(! B.empty()) {
            Integer temp2 = B.pop();
            A.push(temp2);
        }
        return ret;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.empty() && B.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//循环队列
class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    int[] cirQue;
    int head = 0;
    int tail = 0;
    int size = 0;
    int fullLength;
    public MyCircularQueue(int k) {
        cirQue = new int[k];
        fullLength = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size == fullLength) {
            return false;
        }
        cirQue[tail] = value;
        tail ++ ;
        size ++;
        if(tail == fullLength) {
            tail %= fullLength;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }
        head ++;
        size --;
        if(head == fullLength) {
            head %= fullLength;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(size == 0) {
            return -1;
        }
        return cirQue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(size == 0) {
            return -1;
        }
        if(tail == 0) {
            return cirQue[fullLength - 1];
        }
        return cirQue[tail - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(size == fullLength) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

public class HomeWork {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false
    }
}


