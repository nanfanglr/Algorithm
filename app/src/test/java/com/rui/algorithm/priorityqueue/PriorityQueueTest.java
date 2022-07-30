package com.rui.algorithm.priorityqueue;

import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void testMaxPriorityQueue() {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
        for (String s : arr) {
            maxpq.insert(s);
        }
        System.out.println(maxpq.size());
        String del;
        while (!maxpq.isEmpty()) {
            del = maxpq.deleteMax();
            System.out.print(del + ",");
        }
    }

    @Test
    public void testMinPriorityQueue() {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MinPriorityQueue<String> maxpq = new MinPriorityQueue<>(20);
        for (String s : arr) {
            maxpq.insert(s);
        }
        System.out.println(maxpq.size());
        String del;
        while (!maxpq.isEmpty()) {
            del = maxpq.deleteMin();
            System.out.print(del + ",");
        }
    }

    @Test
    public void testIndexMinPriorityQueue() {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        IndexMinPriorityQueue<String> indexMinPQ = new IndexMinPriorityQueue<>(20); //插入
        for (int i = 0; i < arr.length; i++) {
            indexMinPQ.insert(i, arr[i]);
        }
        System.out.println("size=" + indexMinPQ.size());
        //获取最小值的索引
        System.out.println("minIndex=" + indexMinPQ.minIndex());
        //测试修改
        indexMinPQ.changeItem(0, "Z");
        int minIndex = -1;
        while (!indexMinPQ.isEmpty()) {
            minIndex = indexMinPQ.deleteMin();
            System.out.print(minIndex + ",");
        }
    }
}
