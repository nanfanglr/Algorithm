package com.rui.algorithm.sort;

/**
 * 快速排序
 * @param <T>
 */
public class Quick<T> {

    public void sort(Comparable<T>[] data) {
        int lo = 0;
        int hi = data.length - 1;
        sort(data, lo, hi);
    }

    public void sort(Comparable<T>[] data, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int partition = partition(data, lo, hi);
        sort(data, lo, partition - 1);
        sort(data, partition + 1, hi);
    }

    // 1,2,3
    private int partition(Comparable<T>[] data, int lo, int hi) {
        System.out.println("partition lo = " + lo + " hi = " + hi);
        Comparable<T> key = data[lo];
        int left = lo, right = hi + 1;
        while (true) {
            while (less(key, data[--right])) {
                if (right == lo) {
                    break;
                }
            }
            while (less(data[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(data, left, right);
            }
        }
        exchange(data, lo, right);
        return right;
    }

    private boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private void exchange(Comparable<T>[] data, int i, int j) {
        Comparable<T> temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
