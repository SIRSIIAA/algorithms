package questions.zuo.sort.test;

import org.junit.jupiter.api.Test;
import utils.generator.RandomNumberGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SortTest {
    @Test
    public void testSort() {
        /*
         * get methods with reflection
         */
        // change katas class here!
        var classPath = "questions.zuo.sort.Lab";
        var paramClass = int[].class;
        Method insertionSort = null;
        Method bubblingSort = null;
        Method selectionSort = null;
        try {
            var lab = Class.forName(classPath);
            insertionSort = lab.getMethod("insertionSort", paramClass);
            bubblingSort = lab.getMethod("bubblingSort", paramClass);
            selectionSort = lab.getMethod("selectionSort", paramClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        /*
         * unit test
         */
        int size = RandomNumberGenerator.randomInt(0, 10000);
        int min = RandomNumberGenerator.randomInt(10000, 100000);
        int max = RandomNumberGenerator.randomInt(min + 1, min + 100000);
        var arr = RandomNumberGenerator.randomIntArray(size, min, max, true);
        var resArr = Arrays.copyOf(arr, arr.length);
        var insertionArr = Arrays.copyOf(arr, arr.length);
        var bubblingArr = Arrays.copyOf(arr, arr.length);
        var selectionArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(resArr);
        try {
            insertionSort.invoke(null, insertionArr);
            bubblingSort.invoke(null, bubblingArr);
            selectionSort.invoke(null, selectionArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        /*
         * result output
         */
        boolean insertionRes = check(resArr, insertionArr);
        boolean bubblingRes = check(resArr, bubblingArr);
        boolean selectionRes = check(resArr, selectionArr);
        System.out.println(insertionRes ? "passed: insertion sort" : "rejected: insertion sort");
        System.out.println(bubblingRes ? "passed: bubbling sort" : "rejected: bubbling sort");
        System.out.println(selectionRes ? "passed: selection sort" : "rejected: selection sort");
    }

    public boolean check(int[] arr, int[] target) {
        var res = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                res = false;
                break;
            }
        }
        return res;
    }
}
