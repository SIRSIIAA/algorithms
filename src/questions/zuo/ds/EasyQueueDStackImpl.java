package questions.zuo.ds;

import utils.generator.RandomNumberGenerator;

import java.util.LinkedList;
import java.util.Stack;

/**
 * imitate an queue with double stack
 */
public class EasyQueueDStackImpl {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    private final int capacity;

    public EasyQueueDStackImpl(int capacity) {
        this.capacity = capacity;
    }

    public void offer(int i) {
        if (inStack == null) {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }
        if (inStack.size() < capacity) {
            inStack.push(i);
        }
    }

    public int poll() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


    public static void main(String[] args) {
        int capacity = RandomNumberGenerator.randomInt(0, 1000);
        var eqdsi = new EasyQueueDStackImpl(capacity);
        var ints = RandomNumberGenerator.randomIntArray(capacity, 0, 10000, true);
        for (int i = 0; i < capacity; i++) {
            eqdsi.offer(ints[i]);
        }
        var eqdsiSb = new StringBuilder(capacity);
        while (!eqdsi.isEmpty()) {
            eqdsiSb.append(eqdsi.poll());
        }
        var queue = new LinkedList<Integer>();
        for (int i = 0; i < capacity; i++) {
            queue.offer(ints[i]);
        }
        var queueSb = new StringBuilder(capacity);
        while (!queue.isEmpty()) {
            queueSb.append(queue.poll());
        }
        System.out.print(eqdsiSb);
        System.out.print(queueSb);
        System.out.print("\n");
        System.out.println(eqdsiSb.compareTo(queueSb) == 0);
    }
}