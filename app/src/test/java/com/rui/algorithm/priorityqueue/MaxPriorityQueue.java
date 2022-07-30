package com.rui.algorithm.priorityqueue;


public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] data;
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
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

    private void swim(int n) {
        while (n > 1) {
            if (less(n / 2, n)) {
                exchange(n / 2, n);
            }
            n = n / 2;
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
            int max = 2 * i;
            if (2 * i + 1 <= N) {
                if (less(2 * i, 2 * i + 1)) {
                    max = 2 * i + 1;
                }
            }
            if (!less(i, max)) {
                break;
            }
            exchange(i, max);
            i = max;
        }
    }
}
