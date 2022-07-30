package com.rui.algorithm.heap;

public class Heap<T extends Comparable<T>> {
    private T[] data;
    private int N;

    public Heap(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    private void exchange(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void insert(T t) {
        data[++N] = t;
        swim(N);
    }

    private void swim(int i) {
        while (i > 1) {
            if (less(i / 2, i)) {
                //父节点小于子节点，则交换值
                exchange(i / 2, i);
            }
            i = i / 2;
        }
    }

    public T deleteMax() {
        T max = data[1];
        exchange(1, N);
        data[N] = null;
        N--;
        sink(1);
        return max;
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int max;
            if (2 * i + 1 <= N) {
                if (less(2 * i + 1, 2 * i)) {
                    max = 2 * i;
                } else {
                    max = 2 * i + 1;
                }
            } else {
                max = 2 * i;
            }
            if (!less(i, max)) {
                break;
            }
            exchange(i, max);
            i = max;
        }

    }
}
