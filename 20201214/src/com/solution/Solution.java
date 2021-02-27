package com.solution;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-14
 * Time: 18:28
 */
public class Solution {


    /**
     * 使用辅助栈, 再辅助栈中添加元素的时候进行判断, 如果加入的大于当前辅助栈顶的元素, 就再加一个
     * 辅助栈顶元素的数值, 当前一开始栈为空, 直接插入
     */
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!minStack.isEmpty() && minStack.peek() < node) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
