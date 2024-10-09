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
}
