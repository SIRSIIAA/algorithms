package leetcode.medium;

public class MID622 {
    private int left;
    private int right;
    private int capacity;
    private int size;
    private int[] queue;
    public MID622(int k) {
        capacity = k;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        queue[getIdx(right)] = value;
        right++;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        left = getIdx(left + 1);
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[getIdx(left)];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[getIdx(right) == 0 ? capacity - 1 : (getIdx(right) - 1)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int getIdx(int i){
        return i >= capacity ? (i % capacity) : i;
    }
}
