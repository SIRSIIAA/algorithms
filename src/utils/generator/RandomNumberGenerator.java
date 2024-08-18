package utils.generator;

import java.util.HashSet;

public class RandomNumberGenerator {
    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static double randomDouble(double min, double max) {
        return (Math.random() * (max - min) + min);
    }

    public static int[] randomIntArray(int size, int min, int max, boolean duplicate) {
        int[] res = new int[size];
        var set = new HashSet<Integer>(size);
        for (int i = 0; i < res.length; i++) {
            int t;
            do {
                t = randomInt(min, max);
            } while (!duplicate && set.contains(t));
            if (!duplicate) {
                set.add(t);
            }
            res[i] = t;
        }
        return res;
    }
}
