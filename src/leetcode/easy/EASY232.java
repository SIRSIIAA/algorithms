package leetcode.easy;

import java.util.Stack;

public class EASY232 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public EASY232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        if (inStack == null) {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }
        inStack.push(x);
    }

    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}