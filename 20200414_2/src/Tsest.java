import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tsest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        while (true) {
            Integer cur = myStack.pop();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
        System.out.println("================");
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        myStack2.push(4);
        myStack2.push(5);
        myStack2.push(6);
        //System.out.println(myStack2.peek());
        while (true) {
            Integer cur = myStack2.pop();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
        System.out.println("============");
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        //System.out.println(myQueue.peek());
        while (true) {
            Integer cur = myQueue.poll();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
        System.out.println("=================");
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        while (true) {
            Integer cur = myQueue2.poll();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
        System.out.println("==============");
        Stack<Character> stack = new Stack<>();
        stack.push('g');
        stack.push('o');
        stack.push('o');
        stack.push('d');
        while (! stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("===============");
        Queue<String> queue = new LinkedList<>();
        queue.offer("aaa");
        queue.offer("bbb");
        queue.offer("ccc");
        while (! queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
