package questions.zuo.ds.test;

import org.junit.jupiter.api.Test;
import questions.zuo.ds.heap.EasyMaxHeap;

public class EasyHeapTest {
    @Test
    public void testEasyMaxHeap() {
        var heap = new EasyMaxHeap(new int[] {
                2,3,4,5,1,8,7,9,0
        });
        heap.heapSortSinceTop();
        System.out.println(heap);
    }
}
