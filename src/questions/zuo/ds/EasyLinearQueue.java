package questions.zuo.ds;

/**
 * a simple linear queue implementation
 */
public class EasyLinearQueue {
    private int[] queue;
    private int capacity;

    private int left;

    /**
     * a new queue element will be placed at queue[right] directly
     */
    private int right;

    public EasyLinearQueue(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return right - left;
    }

    public boolean isEmpty() {
        return left == right;
    }

    public void offer(int i) {
        if (this.isEmpty()) {
            this.queue = new int[capacity];
        }
        queue[right++] = i;
    }

    public int poll() {
        return queue[left++];
    }

    public int peek() {
        return queue[left];
    }
}