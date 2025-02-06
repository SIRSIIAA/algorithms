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

    public int[] heapSortSinceTop() {
        for (int datum : data) {
            heapInsert(datum);
        }
        while (size > 1) {
            swap(0, size - 1);
            size--;
            heapify(0);
        }

        return data;
    }

    public void heapInsert(int value) {
        data[size++] = value;
        var idx = size - 1;
        while (data[idx] > data[(idx - 1) / 2]) {
            swap(idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    public void heapify(int idx) {
        var l = (idx << 1) + 1;
        while (l < size) {
            var r = (idx << 1) + 2;
            var bigger = ((r < size) && (data[r] > data[l])) ? r : l;
            var max = data[bigger] > data[idx] ? bigger : idx;
            /*
             * must quit when necessary
             */
            if (max == idx) {
                break;
            }
            swap(idx, max);
            idx = max;
            l = (idx << 1) + 1;
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
