package utils.generator.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static utils.generator.RandomNumberGenerator.randomIntArray;

public class RandomNumberGeneratorTest {
    @Test
    public void randomInteArrayTest() {
        var arr = randomIntArray(300, -100, 100, true);
        /*
         * only applicable to positive number
         */
//        var res = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            res ^= arr[i];
//        }
        outer:
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("duplicate");
                    System.out.println("i = " + i + " j = " + j);
                    System.out.println("arr[i] = " + arr[i] + " arr[j] = " + arr[j]);
                    break outer;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
