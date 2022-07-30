package com.rui.algorithm.lineartable;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;
    private int N;

    public Queue() {
        head = new Node<>(null, null);
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(T t) {
        if (last == null) {
            last = new Node<>(t, null);
            head.next = last;
        } else {
            Node<T> oldLast = last;
            last = new Node<>(t, null);
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return oldFirst.item;
    }


    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T> {
        private Node<T> node;

        public QIterator() {
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            Node<T> curr = node.next;
            node = node.next;
            return curr.item;
        }
    }
}
