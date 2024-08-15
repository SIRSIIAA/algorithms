package questions.zuo.bisearch.test;

import org.junit.jupiter.api.Test;

import utils.parser.CommonInputParser;
import questions.zuo.bisearch.Lab;

public class BiSearchTest {
    @Test
    public void testFindTheLeft() {
        var input = "[3,3,3,3,3,3]";
        int[] arr = CommonInputParser.parseIntArrayFromString(input);
        System.out.println(Lab.findTheLeft(arr, 3));
    }

    @Test
    public void testFindTheRight() {
        var input = "[3,5,6,9,13,17,24,36]";
        int[] arr = CommonInputParser.parseIntArrayFromString(input);
        System.out.println(Lab.findTheRight(arr, 15));
    }
}
