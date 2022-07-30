package com.rui.algorithm.sort;

/**
 * 冒泡排序
 */
public class Bubble<T> {

    public void sort(Comparable<T>[] data) {
        if (data == null || data.length < 2)
            return;
        for (int i = data.length - 1; i > 0; i--) {
            //每次遍历比较交换得到最大值，并放到最后的位置
            for (int j = 0; j < i; j++) {
                if (greater(data[j], data[j + 1])) {
                    exchange(data, j, j + 1);
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
