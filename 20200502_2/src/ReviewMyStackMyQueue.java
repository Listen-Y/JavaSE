/**
 * 复习用链表和数组实现栈和队列
 */

import java.util.ArrayList;
import java.util.LinkedList;

class MyStackList {
    private LinkedList<Integer> list = new LinkedList<>();
    //入栈
    public void push(int data) {
        list.add(data);
    }
    //出栈
    public int pop() {
        if(list.isEmpty()) {
            return -1;
        }
        int ret = list.getLast();
        list.removeLast();
        return ret;
    }
    //查栈顶元素
    public int peek() {
        if(list.isEmpty()) {
            return -1;
        }
        return list.getLast();
    }
    //判空
    public boolean empty() {
        return list.isEmpty();
    }
    //查长度
    public int length() {
        return list.size();
    }

}

class MyQueueList {
    private LinkedList<Integer> list = new LinkedList<>();
    //入队列
    public void offer(int data) {
        list.add(data);
    }
    //出队列
    public int poll() {
        if(list.isEmpty()) {
            return -1;
        }
        int ret = list.getFirst();
        list.removeFirst();
        return ret;
    }
    //查看队首元素
    public int peek() {
        if(list.isEmpty()) {
            return -1;
        }
        return list.getFirst();
    }
    //判空
    public boolean empty() {
        return list.isEmpty();
    }
    //查长度
    public int length() {
        return list.size();
    }
}

class MyStackArray {
    private int[] array = new int[10];
    private  int size;
    //入栈
    public void push(int data) {
        if(size == array.length) {
            return;
        }
        array[size] = data;
        size ++;
    }
    //出栈
    public int pop() {
        if(size == 0) {
            return -1;
        }
        int ret = array[size - 1];
        size --;
        return ret;
    }
    //查栈顶元素
    public int peek() {
        if(size == 0) {
            return -1;
        }
        return array[size - 1];
    }
    //判空
    public boolean empty() {
        return size == 0;
    }
    //求长度
    public int length() {
        return size;
    }
}

class MyQueueArray {
    private int[] array = new int[3];
    private int low;
    private int high;
    private int size;
    //入队列
    public void offer(int data) {
        if(size == array.length) {
            return;
        }
        array[high] = data;
        size ++;
        high ++;
        if(high == array.length) {
            high = 0;
        }
    }
    //出队列
    public int poll() {
        if(size == 0) {
            return -1;
        }
        int ret = array[low];
        low ++;
        size --;
        if(low == array.length) {
            low = 0;
        }
        return ret;
    }
    //查看队首元素
    public int peek() {
        if(size == 0) {
            return -1;
        }
        return array[low];
    }
    //判空
    public boolean empty() {
        return size == 0;
    }
    //求长度
    public int length() {
        return size;
    }
}

public class ReviewMyStackMyQueue {
    public static void main(String[] args) {
        MyStackList mySlist = new MyStackList();
        MyQueueList myQlist = new MyQueueList();
        MyStackArray mySarr = new MyStackArray();
        MyQueueArray myQarr = new MyQueueArray();
        mySlist.push(1);
        mySlist.push(2);
        mySlist.push(3);
        mySlist.push(4);
        mySlist.push(5);
        System.out.println(mySlist.peek());
        while (!mySlist.empty()) {
            System.out.print(mySlist.pop()+ " ");
        }
        System.out.println();
        System.out.println("==================");
        mySarr.push(1);
        mySarr.push(2);
        mySarr.push(3);
        mySarr.push(4);
        mySarr.push(5);
        System.out.println(mySarr.peek());
        while (!mySarr.empty()) {
            System.out.print(mySarr.pop()+ " ");
        }
        System.out.println();
        System.out.println("==================");
        myQlist.offer(1);
        myQlist.offer(2);
        myQlist.offer(3);
        myQlist.offer(4);
        myQlist.offer(5);
        System.out.println(myQlist.peek());
        while (!myQlist.empty()) {
            System.out.print(myQlist.poll()+ " ");
        }
        System.out.println();
        System.out.println("==================");
        myQarr.offer(1);
        myQarr.offer(2);
        myQarr.offer(3);
        myQarr.poll();
        myQarr.poll();
        myQarr.offer(4);
        myQarr.offer(5);
        System.out.println(myQarr.peek());
        while (!myQarr.empty()) {
            System.out.print(myQarr.poll()+ " ");
        }
    }
}
