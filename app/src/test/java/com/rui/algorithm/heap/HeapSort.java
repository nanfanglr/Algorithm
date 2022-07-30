package com.rui.algorithm.heap;

public class HeapSort {

    public <T> void sort(Comparable<T>[] source) {
        Comparable<T>[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        int N = heap.length - 1;
        while (N != 1) {
            exchange(heap, 1, N);
            N--;
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    private <T> void createHeap(Comparable<T>[] source, Comparable<T>[] heap) {
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = (heap.length - 1) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    private <T> boolean less(Comparable<T>[] heap, int i, int j) {
        return heap[i].compareTo((T) heap[j]) < 0;
    }

    private <T> void exchange(Comparable<T>[] heap, int i, int j) {
        Comparable<T> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private <T> void sink(Comparable<T>[] heap, int target, int range) {
        while (2 * target <= range) {
            int max = 2 * target;
            if (2 * target + 1 <= range) {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                }
            }
            if (less(heap, target, max)) {
                exchange(heap, target, max);
            }
            target = max;
        }
    }
}
