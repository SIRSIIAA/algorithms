package leetcode.easy;

public class EASY191 {

    public static int bitsCounterByBitwise(int num) {
        int cnt = 0;
        for (int i = 0; i < 31; i++) {
            if ((num & (1 << i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}