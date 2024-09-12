package questions.zuo.ds;

import java.util.LinkedList;

/*
* imitate a stack with queue
* ref: https://leetcode.cn/problems/implement-stack-using-queues/
*/
public class EasyStackDQueueImpl {
    private int movingElem;
    private LinkedList<Integer> queue;

    public EasyStackDQueueImpl() {
        this.queue = new LinkedList<>();
    }

    /**
     * O(n)
     */
    public void push(int i) {
        movingElem = queue.size();
        queue.offer(i);
        for (int j = 0; j < movingElem; j++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue == null ? -1 : queue.poll();
    }

    public int top() {
        return queue == null ? -1 : queue.peek();
    }

    public boolean empty() {
        return queue == null ? false : queue.isEmpty();
    }
}