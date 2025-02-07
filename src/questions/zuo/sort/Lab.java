package questions.zuo.sort;

import questions.zuo.ds.heap.EasyMaxHeap;
import utils.generator.RandomNumberGenerator;

import java.util.Random;

public class Lab {

    /*
     * 1. outer for --> unsorted range
     * 2. find and swap the minimum with the first element of unsorted
     */
    public static void selectionSort(int[] arr) {
        if (isLegal(arr)) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                swap(arr, i, minIdx);
            }
        }
    }

    /*
     * 1. outer for --> times to swap
     * 2. inner for --> exchange the largest of the adjacent elements
     */
    public static void bubblingSort(int[] arr) {
        if (isLegal(arr)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }
    }

    /*
     * 1. outer for --> unsorted range(reverse)
     * 2. inner for --> exchange the largest of the adjacent elements
     */
    public static void bubblingSortImpl01(int[] arr) {
        if (isLegal(arr)) {
            for (int end = arr.length - 1; end > 0; end--) {
                for (int i = 0; i < end; i++) {
                    if (arr[i] > arr[i + 1]) {
                        swap(arr, i, i + 1);
                    }
                }
            }
        }
    }

    /*
     * never compute time complexity with code structure
     * the function below with only one loop but cost O(N^2)
     * another bubbling sort
     */
    public static void bubblingSortImplConfusing(int[] arr) {
        if (isLegal(arr)) {
            int end = arr.length - 1;
            int pointer = 0;
            while (end > 0) {
                if (arr[pointer] > arr[pointer + 1]) {
                    swap(arr, pointer, pointer + 1);
                }
                if (pointer < end - 1) {
                    pointer++;
                    break;
                } else {
                    end--;
                    pointer = 0;
                }
            }
        }
    }

    /*
     * 1. outer for --> sorted range
     * 2. inner for --> find the position of the first element in unsorted range
     */
    public static void insertionSort(int[] arr) {
        if (isLegal(arr)) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j > 0 && arr[j] < arr[j - 1]; j--) {
                    swap(arr, j, j - 1);
                }

            }
        }
    }

    /*
     * swap the element at i & j
     * only int/short/byte
     * i != j
     */
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    /*
     * merge sort with recursion
     */
    public static void mergeSort(int[] arr) {
        recursion(arr, 0, arr.length - 1);
    }

    private static void recursion(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        var mid = left + ((right - left) >> 1);
        recursion(arr, left, mid);
        recursion(arr, mid + 1, right);
        merge(left, mid, right, arr);
    }

    /*
     * mergeSort without recursion implementation
     */
    public static void mergeSortNoRecursion(int[] arr) {
        noRecursion(arr);
    }

    private static void noRecursion(int[] arr) {
        var left = 0;
        var limit = arr.length - 1;
        var l = left;
        /*
         * select a step, double it each time
         * the step contains a half group
         * logN
         */
        for (int step = 1; step < arr.length; step <<= 1) {
            /*
             * merge the elements by group with current step size
             */
            while (l < arr.length) {
                var mid = l + step - 1;
                /*
                 * the limit group does not exist
                 */
                if (mid > limit) {
                    break;
                }
                var r = Math.min((l + (step << 1)) - 1, limit);
                merge(l, mid, r, arr);
                l = r + 1;
            }
            /*
             * set l to 0 manually
             */
            l = left;
        }
    }

    private static void merge(int left, int mid, int right, int[] arr) {
        var lp = left;
        var rp = mid + 1;
        var heap = new int[right - left + 1];
        var hp = 0;
        while (lp <= mid && rp <= right) {
            /*
             * get the left one when equals
             */
            heap[hp++] = arr[lp] <= arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid) {
            heap[hp++] = arr[lp++];
        }
        while (rp <= right) {
            heap[hp++] = arr[rp++];
        }
        System.arraycopy(heap, 0, arr, left, heap.length);
    }

    /*
     * random quick sort
     */
    public static void traditionalRandomQuickSort(int[] arr) {
        traditionalRandomQuickSort(arr, 0, arr.length - 1);
    }

    private static void traditionalRandomQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = arr[RandomNumberGenerator.randomInt(left, right)];
        int mid = tradtionalPartition(arr, target, left, right);
        traditionalRandomQuickSort(arr, left, mid - 1);
        traditionalRandomQuickSort(arr, mid + 1, right);
    }

    private static int tradtionalPartition(int[] arr, int target, int left, int right) {
        var leftBound = left;
        int i;
        int marked = 0;
        for (i = left; i <= right; i++) {
            var cur = arr[i];
            if (cur <= target) {
                swap(arr, i, leftBound);
                if (arr[leftBound] == target) {
                    marked = leftBound;
                }
                leftBound++;
            }
        }
        swap(arr, marked, leftBound - 1);
        return leftBound - 1;
    }

    /*
     * optimized random quick sort
     */
    public static void optimizedRandomQuickSort(int[] arr) {
        optimizedRandomQuickSort(arr, 0, arr.length - 1);
    }

    private static void optimizedRandomQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        var target = arr[RandomNumberGenerator.randomInt(left, right)];
        var bounds = optimizedPartition(arr, target, left, right);
        optimizedRandomQuickSort(arr, left, bounds[0] - 1);
        optimizedRandomQuickSort(arr, bounds[1] + 1, right);
    }

    private static int[] optimizedPartition(int[] arr, int target, int left, int right) {
        var leftBound = left;
        var rightBound = right;
        int i;
        for (i = left; i <= rightBound; i++) {
            var cur = arr[i];
            if (cur < target) {
                swap(arr, i, leftBound++);
            } else if (cur > target) {
                swap(arr, i--, rightBound--);
            }
        }
        return new int[]{
                leftBound, rightBound
        };
    }

    /*
     * heap sort m1 : construct the heap since top
     */
    public static void heapSort1(int[] arr) {
        System.arraycopy(new EasyMaxHeap(arr).heapSortSinceTop(),0,arr,0,arr.length);
    }

    /*
     * heap sort m2 : construct the heap since bottom
     */
    public static void heapSort2(int[] arr) {
        System.arraycopy(new EasyMaxHeap(arr).heapSortSinceBottom(),0,arr,0,arr.length);
    }

    /*
     * inspect common input
     */
    public static boolean isLegal(int[] arr) {
        return arr != null && arr.length >= 2;
    }

    /*
     * random select
     */
    public static int randomSelect(int[] arr, int idx) {
        return -1;
    }

    private static int[] randomSelectPartition(int[] arr, int target, int left, int right) {
        return null;
    }
}
