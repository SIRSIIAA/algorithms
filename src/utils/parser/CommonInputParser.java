package utils.parser;

import utils.Const;

public class CommonInputParser {
    /*
     * the input string must like "[1,2,3,4,5]"
     * all elements must be a legal integer
     */
    public static int[] parseIntArrayFromString(String inPut) {
        if (inPut == null || inPut.isEmpty()) {
            System.out.println(Const.INPUT_ERROR);
            return new int[]{};
        }
        var str = inPut.replace("[", "").replace("]", "");
        var strs = str.split(",");
        int[] res = new int[strs.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(strs[i]);
        }
        return res;
    }
}
