package com.rui.algorithm.tree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;
    private int N;
    private final static boolean RED = true;
    private final static boolean BLACK = false;

    public int size() {
        return N;
    }

    private boolean isRed(Node<Key, Value> node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> h) {
        Node<Key, Value> hRight = h.right;
        Node<Key, Value> hRLeft = hRight.left;
        h.right = hRLeft;
        hRight.left = h;
        hRight.color = h.color;
        h.color = RED;
        return hRight;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> h) {
        Node<Key, Value> hLeft = h.left;
        Node<Key, Value> hlRight = hLeft.right;
        h.left = hlRight;
        hLeft.right = h;
        hLeft.color = h.color;
        h.color = RED;
        return hLeft;
    }

    private void flipColors(Node<Key, Value> h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            N++;
            return new Node<>(key, value, null, null, RED);
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        } else if (compare > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

}
