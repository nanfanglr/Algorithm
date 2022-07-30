package com.rui.algorithm.priorityqueue;

public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] data;
    private int N;

    public MinPriorityQueue(int capacity) {
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
            if (less(n, n / 2)) {
                exchange(n, n / 2);
            }
            n = n / 2;
        }
    }

    public T deleteMin() {
        T min = data[1];
        exchange(1, N);
        data[N] = null;
        N--;
        sink(1);
        return min;
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int min = 2 * i;
            if (2 * i + 1 <= N && less(2 * i + 1, 2 * i)) {
                min = 2 * i + 1;
            }
            if (less(i, min)) {
                break;
            }
            exchange(i, min);
            i = min;
        }
    }

}
