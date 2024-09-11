package utils.parser;

import questions.zuo.ds.*;
import utils.Const;

public class CommonInputParser {
    /*
     * the input string must like "[1,2,3,4,5]"
     * all elements must be a legal integer
     */
    public static int[] parseIntArrayFromString(String inPut) {
        if (inPut == null || inPut.isEmpty()) {
            System.out.println(Const.INPUT_ERROR);
            return new int[] {};
        }
        var strings = parseIntsString(inPut);
        int[] res = new int[strings.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(strings[i]);
        }
        return res;
    }

    public static LinkedNode parseLinkedListFromString(String inPut) {
        var strings = parseIntsString(inPut);
        var dummy = new LinkedNode();
        var pointer = dummy;
        for (String string : strings) {
            pointer.next = new LinkedNode(Integer.parseInt(string));
            pointer = pointer.next;
        }
        return dummy.next;
    }

    private static String[] parseIntsString(String inPut) {
        var str = inPut.replace("[", "").replace("]", "");
        return str.split(",");
    }
}
