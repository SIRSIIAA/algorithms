package questions.zuo.ds.heap;

import java.util.Arrays;

/*
 *  The maximum value of each subtree is at the top
 */
public class EasyMaxHeap extends EasyHeap {
    private int size = 0;
    private final int[] data;

    public EasyMaxHeap(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public void heapSortSinceTop() {
        for (int datum : data) {
            heapInsert(datum);
        }
        while (size > 1) {
            swap(0, size - 1);
            size--;
            heapify(0);
        }
    }

    public void heapInsert(int value) {
        data[size++] = value;
        var idx = size - 1;
        while (data[idx] > data[idx >> 1]) {
            swap(idx, idx >> 1);
            idx = idx >> 1;
        }
    }

    public void heapify(int idx) {
        var l = (idx << 1) + 1;
        var r = (idx << 1) + 2;
        while (l < size) {
            var bigger = ((r < size) && (data[l] > data[r])) ? l : r;
            var max = data[bigger] > data[idx] ? bigger : idx;
            /*
             * must quit when necessary
             */
            if (max == idx){
                break;
            }
            swap(idx, max);
            l = (max << 1) + 1;
        }
    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        data[i] ^= data[j];
        data[j] ^= data[i];
        data[i] ^= data[j];
    }
}
