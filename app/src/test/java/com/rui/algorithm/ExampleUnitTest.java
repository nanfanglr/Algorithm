package com.rui.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSum() {
        System.out.println(sum1(100));
        System.out.println(sum2(100));
    }

    /**
     * 求和：循环
     *
     * @param n
     * @return
     */
    private int sum1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 求和：运算式
     *
     * @param n
     * @return
     */
    private int sum2(int n) {
        return (n + 1) * n / 2;
    }

    @Test
    public void testFun() {
        System.out.println(fun1(10));
        System.out.println(fun2(10));
    }

    /**
     * 阶乘：递归
     *
     * @param n
     * @return
     */
    private long fun1(long n) {
        //递归结束的条件，即递归出口
        if (n == 1) return 1;
        return n * fun1(n - 1);
    }

    /**
     * 阶乘：循环
     *
     * @param n
     * @return
     */
    private long fun2(long n) {
        int result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private int[] reverseArray1(int[] array) {
        int n = array.length;
        int temp;
        for (int start = 0, end = n - 1; start <= end; start++, end--) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }

    private int[] reverseArray2(int[] array) {
        int n = array.length;
        int[] tempArray = new int[n];
        for (int i = 0; i < n; i++) {
            tempArray[n - 1 - i] = array[i];
        }
        return tempArray;
    }


    @Test
    public void testReverseArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(reverseArray1(array)));
        System.out.println(Arrays.toString(reverseArray2(array)));
    }

}