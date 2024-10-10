package questions.zuo.divideconquer;

public class Lab {
    /*
     * little summation question
     */
    public static int getLittleSummation(int[] arr) {
        return littleSummationDivide(arr, 0, arr.length - 1);
    }

    /*
     * divide the whole question into three partitions:
     * 1. the left part
     * 2. the right part
     * 3. the whole part contains 1 & 2 (merge)
     */
    private static int littleSummationDivide(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        var mid = left + ((right - left) >> 1);
        /*
         * left + right + whole(merge)
         */
        return littleSummationDivide(arr, left, mid) + littleSummationDivide(arr, mid + 1, right) + littleSummationConquer(arr, left, mid, right);
    }

    /*
     * conquer the left part & the right part
     */
    private static int littleSummationConquer(int[] arr, int left, int mid, int right) {
        int res = 0;
        int sum = 0;
        /*
         * j for the right part
         * i for the left part
         */
        for (int j = mid + 1, i = left; j < right + 1; j++) {
            /*
             * calculate the little summation of each element in the right part
             */
            while (i < mid + 1 && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            /*
             * add the little summation to the result
             */
            res += sum;
        }
        /*
         * make the whole part orderly
         */
        merge(arr, left, mid, right);
        return res;
    }

    /*
     * just a common merge procedure of merge sort, nothing special
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        var l = left;
        var r = mid + 1;
        int[] heap = new int[right - left + 1];
        var p = 0;
        while (l < mid + 1 && r < right + 1) {
            heap[p++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }
        while (l < mid + 1) {
            heap[p++] = arr[l++];
        }
        while (r < right + 1) {
            heap[p++] = arr[r++];
        }
        System.arraycopy(heap, 0, arr, left, heap.length);
    }

    /*
     * ref: https://leetcode.cn/problems/reverse-pairs/description/
     * get reverse pairs
     */
    public static int getReversePairs(int[] arr) {
        /*
         * non-core logic
         * just avoiding int overflow
         */
        long[] nums = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = (long) arr[i];
        }
        /*
         * core logic
         */
        return reversePairsDivide(nums, 0, arr.length - 1);
    }

    private static int reversePairsDivide(long[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        var mid = left + ((right - left) >> 1);
        return reversePairsDivide(arr, left, mid) + reversePairsDivide(arr, mid + 1, right) + reversePairsConquer(arr, left, mid, right);
    }

    private static int reversePairsConquer(long[] arr, int left, int mid, int right) {
        var res = 0;
        var pairs = 0;
        for (int i = left, j = mid + 1; i < mid + 1; i++) {
            /*
             * for each element in the left part (i)
             * find the first element on the right that is not less than it (j)
             * all the elements on the right (before j) will make a reverse pair with i;
             * meanwhile, the variable pairs tally the counts of reverse pairs;
             */
            while (j < right + 1 && arr[i] > (arr[j] << 1)) {
                pairs++;
                j++;
            }
            /*
             * pairs won't restore to zero, because of EVERY ELEMENT AFTER i ON THE LEFT IS BIGGER THAN i,
             * THEY WILL GENERATE THE SAME PAIRS AS i AT LEAST.
             *
             * add the pairs of i;
             */
            res += pairs;
        }
        /*
         * make the whole part orderly
         */
        reversePairsMerge(arr, left, mid, right);
        return res;
    }

    /*
     * just a common merge procedure of merge sort, nothing special
     */
    private static void reversePairsMerge(long[] arr, int left, int mid, int right) {
        var l = left;
        var r = mid + 1;
        var p = 0;
        var heap = new long[right - left + 1];
        while (l < mid + 1 && r < right + 1) {
            heap[p++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }
        while (l < mid + 1) {
            heap[p++] = arr[l++];
        }
        while (r < right + 1) {
            heap[p++] = arr[r++];
        }
        System.arraycopy(heap, 0, arr, left, heap.length);
    }
}
