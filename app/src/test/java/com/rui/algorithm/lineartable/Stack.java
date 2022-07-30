package com.rui.algorithm.lineartable;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private final Node<T> head;

    private int N;

    public Stack() {
        this.head = new Node<>(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T t) {
        Node<T> oldNext = head.next;
        Node<T> node = new Node<>(t, oldNext);
        head.next = node;
        N++;
    }

    public T pop() {
        Node<T> oldNext = head.next;
        if (oldNext == null) {
            return null;
        }
        head.next = head.next.next;
        N--;
        return oldNext.item;
    }

    public int size() {
        return N;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T> {

        private Node<T> n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node<T> node = n.next;
            n = n.next;
            return node.item;
        }
    }

}
