package com.rui.algorithm.tree;

public class Node<Key, Value> {
    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public boolean color;

    public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right, boolean color) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }
}
