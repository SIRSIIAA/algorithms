package questions.zuo.ds.test;

import org.junit.jupiter.api.Test;
import questions.zuo.ds.LinkedList;
import utils.generator.RandomNumberGenerator;

public class LinkedListTest {
    @Test
    public void testLinkedList() {
//        var str = "[1,2,3,4,5,6,7]";
//        var arrays = CommonInputParser.parseIntArrayFromString(str);
        var size = RandomNumberGenerator.randomInt(0, 1000);
        var arrays = RandomNumberGenerator.randomIntArray(size, 0, 10000, true);
        var list = new LinkedList();
        for (int i : arrays) {
            list.addBeforeHead(i);
        }

        for (int i = 0; i < size; i++) {
            list.removeTail();
        }
    }
}