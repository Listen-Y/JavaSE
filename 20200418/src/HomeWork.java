import java.util.*;
//ping的次数
class RecentCounter {
    Queue<Integer> queue = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        if(queue.isEmpty()) {
            queue.offer(t);
            return 1;
        }
        while( !queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//双端循环对列
class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    int[] array;
    int head;
    int tail = 1;
    int size;
    int fullLength;
    public MyCircularDeque(int k) {
        array = new int[k];
        fullLength = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == fullLength) {
            return false;
        }
        if(size == 0) {
            array[head] = value;
            head = fullLength - 1;
            size ++;
            return true;
        }
        array[head] = value;
        head --;
        if(head == -1) {
            head = fullLength - 1;
        }
        size ++;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == fullLength) {
            return false;
        }
        if(size == 0) {
            array[tail] = value;
            tail ++;
            size ++;
            return true;
        }
        if(tail == fullLength) {
            tail = 0;
        }
        array[tail] = value;
        tail ++;
        if(tail == fullLength) {
            tail = 0;
        }
        size ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) {
            return false;
        }
        if(head == fullLength - 1) {
            head = 0;
            size --;
            return true;
        }
        head ++;
        size--;
        if(size == 0) {
            tail = 1;
            head = 0;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) {
            return false;
        }
        if(tail == 0) {
            tail = fullLength - 1;
            size --;
            return true;
        }
        tail --;
        size --;
        if(size == 0) {
            tail = 1;
            head = 0;
        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) {
            return -1;
        }
        if(head == fullLength - 1) {
            return array[0];
        }
        return array[head + 1];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0) {
            return -1;
        }
        if(tail == 0) {
            return array[fullLength - 1];
        }
        return array[tail - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == fullLength;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//判断有#的字符串是否相等
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> A = new Stack<>();
        Stack<Character> B = new Stack<>();
        if(S == null || T == null) {
            return false;
        }
        for(int i = 0; i < S.length(); i ++) {
            char ch = S.charAt(i);
            if(ch == '#') {
                if (A.size() != 0) {
                    A.pop();
                }
                continue;
            }
            A.push(ch);
        }
        for(int i = 0; i < T.length(); i ++) {
            char ch = T.charAt(i);
            if(ch == '#') {
                if (B.size() != 0) {
                    B.pop();
                    continue;
                }
                continue;
            }
            B.push(ch);
        }
        if(A.size() != B.size()) {
            return false;
        }
        int ALength = A.size();
        for(int i = 0; i < ALength; i ++) {
            char charA = A.pop();
            char charB = B.pop();
            if(charA != charB) {
                return false;
            }
        }
        return true;
    }
}
//逆波兰表达式求值
class Solution1 {
    public int add(int x, int y) {
        return x + y;
    }
    public int jian(int x, int y) {
        return x - y;
    }
    public int chu(int x, int y) {
        return x / y;
    }
    public int cheng(int x, int y) {
        return x * y;
    }

    public char stringToChar(String string) {
        char[] chars = string.toCharArray();
        int sum = 0;
        for(int i = chars.length - 1, j = 0; i >= 0; i --, j ++) {
            sum += (chars[j] - '0') * (int) Math.pow(10, i);
        }
        return (char) (sum +'0');
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String string : tokens) {
            char ch = '0';
            if(string.length() == 1) {
                ch = string.charAt(0);
            }else if(string.charAt(0) != '-') {
                ch = stringToChar(string);
            }else {
                String[] s1 = string.split("-");
                char ret = stringToChar(s1[1]);
                int num = ('0' - ret);
                stack.push(num);
                continue;
            }
            if(ch != '+' && ch != '-' && ch != '/' && ch != '*') {
                int num = ch - '0';
                stack.push(num);
                continue;
            }
            int y = stack.pop();
            int x = stack.pop();
            if(ch == '+') {
                int num = add(x,y);
                stack.push(num);
                continue;
            }
            if(ch == '-') {
                int num = jian(x,y);
                stack.push(num);
                continue;
            }
            if(ch == '*') {
                int num = cheng(x,y);
                stack.push(num);
                continue;
            }
            int num = chu(x,y);
            stack.push(num);
        }
        return stack.pop();
    }
}

/**
 * Stack
 */
//顺序表
 class MyStack {
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



public class HomeWork {
    //是否是弹出栈的序列
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null) {
            return false;
        }
        if(pushA.length != popA.length) {
            return false;
        }
        if(pushA.length == 0) {
            return false;
        }
        Stack<Integer> in = new Stack<>();
        Queue<Integer> out = new LinkedList<>();
        for(int i : popA) {
            out.offer(i);
        }
        for(int i : pushA) {
            if(out.isEmpty()) {
                break;
            }
            int key = out.peek();
            if(key != i) {
                in.push(i);
            }else {
                out.poll();
                while(!in.empty() && in.peek().equals(out.peek())) {
                    in.pop();
                    out.poll();
                }
            }
        }
        return in.empty();
    }


    public static void main(String[] args) {
        /*Solution solution = new Solution();
        String str1 = "abcd";
        String str2 = "bbcd";
        System.out.println(solution.backspaceCompare(str1, str2));*/
        /*int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,3,4,5};
        System.out.println(IsPopOrder(arr1, arr2));*/
        String s = "-13";
        String[] s1 = s.split("-");
        char[] chars = s1[1].toCharArray();
        int sum = 0;
        for(int i = chars.length - 1, j = 0; i >= 0; i --, j ++) {
            sum += (chars[j] - '0') * (int) Math.pow(10, i);
        }
        char ret = (char) (sum +'0');
        int ch = '0' - ret;
        System.out.println(ch);
    }
}
