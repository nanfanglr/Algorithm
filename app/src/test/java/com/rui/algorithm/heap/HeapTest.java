package com.rui.algorithm.heap;

import org.junit.Test;

import java.util.Arrays;

public class HeapTest {

    @Test
    public void tesHeap() {
        Heap<String> heap = new Heap<String>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        String del;
        while ((del = heap.deleteMax()) != null) {
            System.out.print(del + ",");
        }
    }

    @Test
    public void testHeapSort() {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
