package questions.zuo.divideconquer.test;

import org.junit.jupiter.api.Test;
import questions.zuo.divideconquer.Lab;
import utils.generator.RandomNumberGenerator;
import utils.parser.CommonInputParser;

import java.util.Arrays;

public class LittleSummationTest {
    @Test
    public void testLittleSummation() {
        var arr = new int[]{
                1, 3, 5, 2, 4, 6
        };
        var arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println(Lab.getLittleSummation(arr));
        System.out.println(getLittleSummation(arrCopy));
    }

    @Test
    public void littleSummationTest() {
        var size = RandomNumberGenerator.randomInt(0, 1000);
        var arr = RandomNumberGenerator.randomIntArray(size, 0, 1000, true);
        var arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("summation 0: " + Lab.getLittleSummation(arr));
        System.out.println("summation 1: " + getLittleSummation(arrCopy));
    }

    private static int getLittleSummation(int[] arr) {
        var sum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    @Test
    public void testReversePairs() {
        var arr = new int[]{
                1, 3, 2, 3, 1
        };
        var arr2 = new int[]{
                2, 4, 3, 5, 1
        };
        var arr3 = CommonInputParser.parseIntArrayFromString("[2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]");
        System.out.println(getReversePairs(arr));
        System.out.println(Lab.getReversePairs(arr));
        System.out.println(getReversePairs(arr2));
        System.out.println(Lab.getReversePairs(arr2));
        System.out.println(getReversePairs(arr3));
        System.out.println(Lab.getReversePairs(arr3));
    }

    private static int getReversePairs(int[] arr) {
        var pairs = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    @Test
    public void reversePairsTest() {
        var size = RandomNumberGenerator.randomInt(0, 1000);
        var arr = RandomNumberGenerator.randomIntArray(size, 0, 1000, true);
        var arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("pairs 0: " + Lab.getReversePairs(arr));
        System.out.println("pairs 1: " + getReversePairs(arrCopy));
    }
}