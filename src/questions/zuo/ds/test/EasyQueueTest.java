package questions.zuo.ds.test;

import org.junit.jupiter.api.Test;
import questions.zuo.ds.EasyDeque;
import questions.zuo.ds.EasyLinearQueue;
import utils.parser.CommonInputParser;

public class EasyQueueTest {
    @Test
    public void testEasyLinearQueue() {
        int size = 100;
        var elq = new EasyLinearQueue(size);
        for (int i = 0; i < size; i++) {
            elq.offer(i);
        }
        while (!elq.isEmpty()) {
            System.out.printf(elq.poll() + "");
        }
    }

    @Test
    public void testEasyArrayDeque() {
        var str = "[1,2,3,4,5,6,7,8,9]";
        var array = CommonInputParser.parseIntArrayFromString(str);
        var size = array.length;
        var deque = new EasyDeque(size);
        for (int i = 0; i < size; i++) {
            deque.offerHead(array[i]);
        }
        System.out.println(deque);

        System.out.println("=============================");
        while (!deque.isEmpty()) {
            deque.pollTail();
            System.out.println("==== pollHead " + deque);
        }
    }
}
