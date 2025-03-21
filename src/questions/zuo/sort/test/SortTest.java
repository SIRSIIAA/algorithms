package questions.zuo.sort.test;

import org.junit.jupiter.api.Test;
import questions.zuo.sort.Lab;
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
        Method mergeSort = null;
        Method mergeSortNoRecursion = null;
        Method trRandomQuickSort = null;
        Method heapSort1 = null;
        Method heapSort2 = null;
        try {
            var lab = Class.forName(classPath);
            insertionSort = lab.getMethod("insertionSort", paramClass);
            bubblingSort = lab.getMethod("bubblingSort", paramClass);
            selectionSort = lab.getMethod("selectionSort", paramClass);
            mergeSort = lab.getMethod("mergeSort", paramClass);
            mergeSortNoRecursion = lab.getMethod("mergeSortNoRecursion", paramClass);
            trRandomQuickSort = lab.getMethod("traditionalRandomQuickSort", paramClass);
            heapSort1 = lab.getMethod("heapSort1", paramClass);
            heapSort2 = lab.getMethod("heapSort2", paramClass);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
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
        var mergeArr0 = Arrays.copyOf(arr, arr.length);
        var mergeArr1 = Arrays.copyOf(arr, arr.length);
        var quickArr0 = Arrays.copyOf(arr, arr.length);
        var quickArr1 = Arrays.copyOf(arr, arr.length);
        var heapSortArr0 = Arrays.copyOf(arr, arr.length);
        var heapSortArr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(resArr);
        try {
            assert insertionSort != null;
            insertionSort.invoke(null, insertionArr);
            assert bubblingSort != null;
            bubblingSort.invoke(null, bubblingArr);
            assert selectionSort != null;
            selectionSort.invoke(null, selectionArr);
            assert mergeSort != null;
            mergeSort.invoke(null, mergeArr0);
            assert mergeSortNoRecursion != null;
            mergeSortNoRecursion.invoke(null, mergeArr1);
            assert trRandomQuickSort != null;
            trRandomQuickSort.invoke(null, quickArr0);
            assert heapSort1 != null;
            heapSort1.invoke(null, heapSortArr0);
            assert heapSort2 != null;
            heapSort2.invoke(null, heapSortArr1);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        /*
         * result output
         */
        boolean insertionRes = check(resArr, insertionArr);
        boolean bubblingRes = check(resArr, bubblingArr);
        boolean selectionRes = check(resArr, selectionArr);
        boolean mergeSortRes = check(resArr, mergeArr0);
        boolean mergeSortNoRecursionRes = check(resArr, mergeArr1);
        boolean trRandomQuickSortRes = check(resArr, quickArr0);
        boolean heapSort1Res = check(resArr, heapSortArr0);
        boolean heapSort2Res = check(resArr, heapSortArr1);
        System.out.println(insertionRes ? "passed: insertion sort" : "rejected: insertion sort");
        System.out.println(bubblingRes ? "passed: bubbling sort" : "rejected: bubbling sort");
        System.out.println(selectionRes ? "passed: selection sort" : "rejected: selection sort");
        System.out.println(mergeSortRes ? "passed: merge sort" : "rejected: merge sort");
        System.out.println(mergeSortNoRecursionRes ? "passed: merge sort no recursion" : "rejected: merge sort no recursion sort");
        System.out.println(heapSort1Res ? "passed: heap sort 1" : "rejected: heap sort 1");
        System.out.println(heapSort2Res ? "passed: heap sort 2" : "rejected: heap sort 2");
        /*
         * quick sort will cause stack overflow …
         */
//        System.out.println(trRandomQuickSortRes ? "passed: traditional random quick sort" : "rejected: traditional random quick sort");
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

    public void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testMergeNoRecusion() {
        var arr = new int[]{
                2, 3, 4, 5, 1, 8, 7, 9, 0
        };
        printArray(arr);
        Lab.mergeSortNoRecursion(arr);
        printArray(arr);
    }

    @Test
    public void testQuickSort() {
        var arr = new int[]{
                5,3,6,2,4,3,5,6,7,2,9
        };
        Lab.optimizedRandomQuickSort(arr);
        printArray(arr);
    }
}
