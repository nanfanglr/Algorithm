package com.rui.algorithm.sort;

/**
 * 选择排序
 */
public class Selection<T>  {

    public void sort(Comparable<T>[] data) {
        if (data == null || data.length < 2)
            return;
        for (int i = 0; i <= data.length - 2; i++) {
            //先假定最小值所在索引为起始位置i,然后与后面的数据逐个比较
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (greater(data[minIndex], data[j])) {
                    //如果大于后面的数据，则重新设置最小值的索引
                    minIndex = j;
                }
            }
            //得到本次遍历的最小值索引，并与起始位置i进行值交换
            exchange(data, i, minIndex);
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
