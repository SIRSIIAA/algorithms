package questions.zuo.ds;

/**
 * easy linear circle queue implementation
 */
public class EasyLinearCircleQueue {
    private int[] queue;
    private final int capacity;

    private int size;

    private int left;

    /**
     * a new queue element will be placed at queue[right] directly
     */
    private int right;

    public EasyLinearCircleQueue(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(int i) {
        if (this.isEmpty()) {
            this.queue = new int[capacity];
        }
        if (size < capacity) {
            int idx = getIdx(right);
            queue[idx] = i;
            right++;
            size++;
        }
    }

    public int poll() {
        int idx = getIdx(left);
        int res = queue[idx];
        left++;
        size--;
        return res;
    }

    public int peek() {
        return queue[getIdx(left)];
    }

    private int getIdx(int i) {
        return i >= capacity ? i % capacity : i;
    }
}