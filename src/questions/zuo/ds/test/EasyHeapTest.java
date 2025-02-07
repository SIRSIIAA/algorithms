package questions.zuo.ds.test;

import org.junit.jupiter.api.Test;
import questions.zuo.ds.heap.EasyMaxHeap;

import java.util.Arrays;

public class EasyHeapTest {
    @Test
    public void testEasyMaxHeap() {
        var arr1 = new int[] {
                2, 3, 4, 5, 1, 8, 7, 9, 0
        };
        var arr2 = new int[] {
                4,1,2,0,-2
        };
        var heap = new EasyMaxHeap(arr1);
        var res2 = heap.heapSortSinceBottom();
        System.out.println(Arrays.toString(res2));
    }
}
