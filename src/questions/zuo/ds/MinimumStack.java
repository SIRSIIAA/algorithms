package questions.zuo.ds;

import java.util.Stack;

/*
* imitate a stack with queue
* ref: https://leetcode.cn/problems/min-stack/description/
*/
public class MinimumStack {
    private Stack<Integer> data;
    private Stack<Integer> minimum;

    public MinimumStack() {
        data = new Stack<>();
        minimum = new Stack<>();
    }

    public void push(int i) {
        data.push(i);
        updateMinimum(i);
    }

    public int pop() {
        minimum.pop();
        return data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minimum.peek();
    }

    private void updateMinimum(int i) {
        if (minimum.isEmpty()) {
            minimum.push(i);
        } else {
            minimum.push(Math.min(i, minimum.peek()));
        }
    }
}