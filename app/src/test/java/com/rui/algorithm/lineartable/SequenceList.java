package com.rui.algorithm.lineartable;

import androidx.annotation.NonNull;

import java.util.Iterator;

/**
 * 线性表
 */
public class SequenceList<T> implements Iterable<T> {

    private T[] elements;

    private int N;

    public SequenceList(int capacity) {
        elements = (T[]) new Object[capacity];
        N = 0;
    }

    public void clear() {
        N = 0;
    }

    public boolean isEmpty() {
        return N != 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        return elements[i];
    }

    public void insert(T t) {
        if (N == elements.length) {
            resize(elements.length * 2);
        }
        elements[N++] = t;
    }

    public void insert(int i, T t) {
        if (i < 0 || i > N) {
            throw new RuntimeException("插入位置不合法");
        }
        if (N == elements.length) {
            resize(elements.length * 2);
        }
        for (int index = N; index > i; index--) {
            elements[index] = elements[index - 1];
        }
        elements[i] = t;
        N++;
    }

    public T remove(int i) {
        if (i < 0 || i > N) {
            throw new RuntimeException("当前要删除的元素不存在");
        }
        T result = elements[i];
        for (int index = i; index < N - 1; index++) {
            elements[index] = elements[index + 1];
        }
        N--;
        if (N > 0 && N < elements.length / 4) {
            resize(elements.length / 2);
        }
        return result;
    }

    public int indexOf(T t) {
        if (t == null) {
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++) {
            if (elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void showElements() {
        for (int i = 0; i < N; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    private void resize(int newSize) {
        T[] temp = elements;
        elements = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            elements[i] = temp[i];
        }
    }

    public int capacity() {
        return elements.length;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cur;

        public SIterator() {
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < N;
        }

        @Override
        public Object next() {
            return elements[cur++];
        }
    }
}
