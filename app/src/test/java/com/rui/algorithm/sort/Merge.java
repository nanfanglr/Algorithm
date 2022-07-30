package com.rui.algorithm.sort;

/**
 * 归并排序
 */
public class Merge<T> {

    private Comparable[] assist;

    public void sort(Comparable<T>[] data) {
        assist = new Comparable[data.length];
        int lo = 0;
        int hi = data.length - 1;
        sort(data, lo, hi);
    }

    //sort(data,0,7)
    //sort(data,0,3) sort(data,4,7)
    //sort(data,0,1) sort(data,2,3) sort(data,4,5) sort(data,6,7)
    //sort(data,0,0) sort(data,1,1) sort(data,2,2) sort(data,3,3) sort(data,4,4) sort(data,5,5) sort(data,6,6) sort(data,7,7)
    public void sort(Comparable<T>[] data, int lo, int hi) {
        System.out.println("sort data lo = " + lo + " hi = " + hi);
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(data, lo, mid);
        sort(data, mid + 1, hi);
        merge(data, lo, mid, hi);
    }

    private void merge(Comparable<T>[] data, int lo, int mid, int hi) {
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (less(data[p1], data[p2])) {
                assist[i++] = data[p1++];
            } else {
                assist[i++] = data[p2++];
            }
        }
        while (p1 <= mid) {
            assist[i++] = data[p1++];
        }
        while (p2 <= hi) {
            assist[i++] = data[p2++];
        }
        for (int index = lo; index <= hi; index++) {
            data[index] = assist[index];
        }
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
