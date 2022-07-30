package com.rui.algorithm.symboltable;

public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    private Node head;
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node pre = head;
        Node curr = head.next;
        while (curr != null && key.compareTo(curr.key) > 0) {
            pre = curr;
            curr = curr.next;
        }
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
            return;
        }
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        N++;
    }

    public void delete(Key key) {
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    private class Node {
        public Key key;
        public Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
