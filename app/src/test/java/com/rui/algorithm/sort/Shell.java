package com.rui.algorithm.sort;

/**
 * 希尔排序
 * 一种基于分组的插入排序
 */
public class Shell<T> {

    public void sort(Comparable<T>[] data) {
        int N = data.length;
        int h = 1;
        while (h < N / 2) {
            h = h * 2 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(data[j - h], data[j])) {
                        exchange(data, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            h /= 2;
        }
    }

    private boolean greater(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) > 0;
    }

    private void exchange(Comparable<T>[] data, int i, int j) {
        Comparable<T> temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
