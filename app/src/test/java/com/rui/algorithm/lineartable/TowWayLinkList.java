package com.rui.algorithm.lineartable;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T> {

    private Node head;

    private Node last;

    private int N;

    public TowWayLinkList() {
        last = null;
        head = new Node(null, null, null);
    }

    public void clear() {
        last = null;
        head.next = null;
        head.pre = null;
        head.item = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(T t) {
        if (last == null) {
            last = new Node(t, head, null);
            head.next = last;
        } else {
            Node oldLast = last;
            Node node = new Node(t, oldLast, null);
            oldLast.next = node;
            last = node;
        }
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("illegal position");
        }
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(t, pre, curr);
        curr.pre = newNode;
        pre.next = newNode;
        N++;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("illegal position");
        }
        Node curr = head.next;
        for (int index = 0; index < i; index++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.next.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("illegal position");
        }
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node curr_next = curr.next;
        pre.next = curr_next;
        curr_next.pre = pre;
        N--;
        return curr.item;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }


    private class Node {
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        T item;
        Node pre;
        Node next;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }
}
