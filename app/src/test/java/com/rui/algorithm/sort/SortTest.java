package com.rui.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    @Test
    public void testBubbleSort() {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        new Bubble<Integer>().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testSelectSort() {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        new Selection<Integer>().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testInsertionSort() {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        new Insertion<Integer>().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testShellSort() {
        Integer[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new Shell<Integer>().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testMergeSort() {
//        Integer[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] a = {1, 2, 3};
        new Merge<Integer>().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testQuickSort() {
//        Integer[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] a = {1, 2, 3};
        new Quick<Integer>().sort(a);
        System.out.println(Arrays.toString(a));
    }
}
