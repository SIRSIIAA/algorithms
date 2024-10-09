package questions.zuo.ds;

import java.util.Arrays;

/**
 * implement a deque with an array
 * can not resize
 */
public class EasyDeque {

    private int size;
    private final int capacity;
    private int[] deque;
    private int left;
    private int right;

    public EasyDeque(int i) {
        capacity = i;
    }

    private void init() {
        deque = new int[capacity];
    }

    public void offerHead(int i) {
        if (deque == null) {
            init();
        }
        if (size == 0) {
            deque[left] = i;
            size++;
            return;
        }
        if (size < capacity) {
            if (left == 0) {
                left = capacity - 1;
                deque[left] = i;
            } else {
                deque[--left] = i;
            }
            size++;
        }
    }

    public void offerTail(int i) {
        if (deque == null) {
            init();
        }
        if (size == 0) {
            deque[left] = i;
            size++;
        }
        if (size < capacity) {
            if (right == capacity - 1) {
                right = 0;
                deque[right] = i;
            } else {
                deque[++right] = i;
            }
            size++;
        }
    }

    public int pollHead() {
        int res = -1;
        if (deque == null || size == 0) {
            return res;
        }
        if (left == capacity - 1) {
            res = deque[left];
            left = 0;
        } else {
            res = deque[left++];
        }
        size--;
        return res;
    }

    public int pollTail() {
        int res = -1;
        if (deque == null || size == 0) {
            return res;
        }
        if (right == 0) {
            res = deque[right];
            right = capacity - 1;
        } else {
            res = deque[right--];
        }
        size--;
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String res = "";
        if (size == 0) {
            return "[]";
        }
        if (left <= right) {
            var arr = new int[size];
            System.arraycopy(deque, left, arr, 0, size);
            res += Arrays.toString(arr);
        } else {
            var preHalf = new int[capacity - left];
            var nextHalf = new int[right + 1];
//            System.out.println("deque " + Arrays.toString(deque));
            System.arraycopy(deque, left, preHalf, 0, capacity - left);
//            System.out.println("preHalf " + Arrays.toString(preHalf));
            System.arraycopy(deque, 0, nextHalf, 0, right + 1);
//            System.out.println("nextHalf " + Arrays.toString(nextHalf));
            res += Arrays.toString(preHalf) + Arrays.toString(nextHalf);
        }
        return res;
    }
}
