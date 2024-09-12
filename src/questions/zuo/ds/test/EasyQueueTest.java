package questions.zuo.ds.test;

import org.junit.jupiter.api.Test;
import questions.zuo.ds.EasyLinearQueue;

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
}
