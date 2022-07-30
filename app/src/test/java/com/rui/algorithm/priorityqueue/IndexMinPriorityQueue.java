package com.rui.algorithm.priorityqueue;

import java.util.Arrays;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] data;
    private int[] pq;
    private int[] qp;
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;
        Arrays.fill(qp, -1);
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(int i, int j) {
        return data[pq[i]].compareTo(data[pq[j]]) < 0;
    }

    private void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public int minIndex() {
        return pq[1];
    }

    public void insert(int i, T t) {
        if (contains(i)) {
            throw new RuntimeException("index existing");
        }
        N++;
        data[i] = t;
        pq[N] = i;
        qp[i] = N;
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

    public int deleteMin() {
        int min = pq[1];
        exchange(1, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        data[min] = null;
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
            if (less(i, min)) break;
            exchange(i, min);
            i = min;
        }
    }

    public void deleteItem(int i) {
        int k = qp[i];
        exchange(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        data[i] = null;
        N--;
        sink(k);
        swim(k);
    }

    public void changeItem(int i, T t) {
        data[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }


}