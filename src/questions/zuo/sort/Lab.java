package questions.zuo.sort;

public class Lab {

    /*
     * 1. outer for --> unsorted range
     * 2. find and swap the minimum with the first element of unsorted
     */
    public static void selectionSort(int[] arr) {
        if(isLegal(arr)){
            for (int i = 0; i < arr.length - 1; i++) {
                int minIdx  = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                swap(arr,i,minIdx);
            }
        }
    }

    /*
     * 1. outer for --> times to swap
     * 2. inner for --> exchange the larger of the adjacent elements
     */
    public static void bubblingSort(int[] arr) {
        if (isLegal(arr)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j+1]) {
                        swap(arr, j, j+1);
                    }
                }
            }
        }
    }

    /*
     * 1. outer for --> unsorted range(reverse)
     * 2. inner for --> exchange the larger of the adjacent elements
     */
    public static void bubblingSortImpl01(int[] arr){
        if(isLegal(arr)){
            for (int end = arr.length - 1; end > 0; end--) {
                for (int i = 0; i < end; i++) {
                    if (arr[i] > arr[i+1]) {
                        swap(arr, i, i+1);
                    }
                }
            }
        }
    }

    /*
     * 1. outer for --> sorted range
     * 2. inner for --> find the position of the first element in unsorted range
     */
    public static void insertionSort(int[] arr){
        if(isLegal(arr)){
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i+1; j > 0 && arr[j] < arr[j-1]; j--) {
                    swap(arr, j, j-1);
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
     * inspect common input  
     */
    public static boolean isLegal(int[] arr){
        return (arr == null || arr.length < 2) ? false : true;
    }
}
