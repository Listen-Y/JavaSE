import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class MyStack {
    /** Initialize your data structure here. */
    List<Integer> list = new LinkedList<>();
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ret = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return ret;
    }

    /** Get the top element. */
    public int top() {
        return list.get(list.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}

public class Work {

    public static boolean isValid(String s) {
        if(s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
                continue;
            }
            if(stack.empty()) {
                return false;
            }
            char chPoll = stack.pop();
            if(ch == '}' && chPoll == '{') {
                continue;
            }
            if(ch == ']' && chPoll == '[') {
                continue;
            }
            if(ch == ')' && chPoll == '(') {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        /*List<Integer> list = new LinkedList<>();
        System.out.println(list.isEmpty());*/
        System.out.println("=============");
        MyStack myStack = new MyStack();
        System.out.println(myStack.empty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        while (! myStack.empty()) {
            System.out.println(myStack.pop());
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        System.out.println(deque.pollLast());
    }
}
