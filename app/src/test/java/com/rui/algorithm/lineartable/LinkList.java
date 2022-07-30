package com.rui.algorithm.lineartable;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    private Node head;
    private int N;

    public LinkList() {
        head = new Node(null, null);
        N = 0;
    }

    public void clear() {
        head.next = null;
        head.item = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N != 0;
    }

    public T get(int i) {
        if (i < 0 || i > N) {
            throw new RuntimeException("illegal position");
        }
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i > N) {
            throw new RuntimeException("illegal position");
        }
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(t, curr);
        pre.next = newNode;
        N++;
    }

    public T remove(int i) {
        if (i < 0 || i > N) {
            throw new RuntimeException("illegal position");
        }
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        pre.next = curr.next;
        N--;
        return curr.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        if (N == 0) {
            return;
        }
        reverse(head.next);
    }

    /**
     * 1->2->3
     * 1<-2<-3
     * @param curr
     * @return
     */
    public Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }

        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T> {
        private Node n;

        public LIterator() {
            this.n = head;
        }

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

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
