package questions.zuo.ds.test;

import org.junit.jupiter.api.Test;
import questions.zuo.ds.LinkedList;
import utils.parser.CommonInputParser;

public class LinkedListTest {
    @Test
    public void testLinkedList() {
        var str = "[1]";
        var arrays = CommonInputParser.parseIntArrayFromString(str);
        var list = new LinkedList();
        for (int i : arrays) {
            list.addFirst(i);
        }
        System.out.println(list);
    }
}