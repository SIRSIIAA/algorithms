package questions.zuo.bisearch;

public class Lab {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            /*
             * to avoid overflow
             */
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /*
     * find the first number >= target in a sorted array
     */
    public static int findTheLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    /*
     * find the last number <= target in an sorted array
     */
    public static int findTheRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    /*
     * find the peek value in a special array
     * the array needs to meet:
     * 1. different adjacent elements
     */
    public static int findThePeek(int[] arr) {
        /*
         * boundary
         */
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        /*
         * primary logic
         */
        if (arr[0] > arr[1]) {
            return 0;
        } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        } else {
            int left = 1;
            int right = arr.length - 2;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
