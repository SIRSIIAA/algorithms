package questions.zuo.ds;

import java.util.LinkedList;
import java.util.Queue;

public class EasyLinkedQueue {
    private final Queue<Integer> queue = new LinkedList<>();

    public int size() {
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    /**
     * insert an element to the tail of the queue
     */
    public void offer(int num) {
        this.queue.offer(num);
    }

    /**
     * return and remove the first element of the queue
     */
    public int poll() {
        var res = this.queue.poll();
        return res == null ? Integer.MIN_VALUE : res;
    }

    /**
     * return and without remove the fist element of the queue
     */
    public int peek() {
        var res = this.queue.peek();
        return res == null ? Integer.MIN_VALUE : res;
    }
}