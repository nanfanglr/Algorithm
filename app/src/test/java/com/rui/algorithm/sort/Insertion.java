package com.rui.algorithm.sort;

/**
 * 插入排序
 */
public class Insertion<T> {

    public void sort(Comparable<T>[] data) {
        if (data == null || data.length < 2)
            return;
        for (int i = 1; i < data.length; i++) {
            //当前元素为a[i],依次和i前面的元素比较，找到一个小于等于a[i]的元素
            for (int j = i; j > 0; j--) {
                if (greater(data[j - 1], data[j])) {
                    //前一个位置数据比后一个数据大则交换数据
                    exchange(data, j - 1, j);
                } else {
                    //找到该元素，结束循环比较
                    break;
                }
            }
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
