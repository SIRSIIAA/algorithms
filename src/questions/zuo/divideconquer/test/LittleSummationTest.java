package questions.zuo.divideconquer.test;

import org.junit.jupiter.api.Test;
import questions.zuo.divideconquer.Lab;
import utils.generator.RandomNumberGenerator;

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
}