package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-29
 * Time: 17:55
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node h1 = new Node(6);
        Node t1 = h1;
        t1.next = new Node(1);
        t1 = t1.next;
        t1.next = new Node(7);
        t1 = t1.next;
        t1.next = new Node(9);
        t1 = new Node(5);
        Node t2 = t1;
        t2.next = new Node(9);
        t2 = t2.next;
        t2.next = new Node(2);
        Node node = solution.add(h1, t1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
