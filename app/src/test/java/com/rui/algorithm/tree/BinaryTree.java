package com.rui.algorithm.tree;

import com.rui.algorithm.lineartable.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int N;

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            N++;
            return new Node<>(key, value, null, null);
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = put(node.right, key, value);
        } else if (compare < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            return get(node.right, key);
        } else if (compare < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = delete(node.right, key);
        } else if (compare < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.right == null) {
                N--;
                return node.left;
            }
            if (node.left == null) {
                N--;
                return node.right;
            }
            Node<Key, Value> min = node.right;
            while (min.left != null) {
                min = min.left;
            }
            Node<Key, Value> temp = node.right;
            while (temp.left != null) {
                if (temp.left.left == null) {
                    temp.left = null;
                } else {
                    temp = temp.left;
                }
            }
            min.left = node.left;
            min.right = node.right;
            node = min;
            N--;
        }
        return node;
    }

    public Key min() {
        return min(root);
    }

    public Key min(Node<Key, Value> node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.key;
        }
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node<Key, Value> node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.key;
        }
    }

    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node<Key, Value> node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        keys.enqueue(node.key);
        if (node.left != null) {
            preErgodic(node.left, keys);
        }
        if (node.right != null) {
            preErgodic(node.right, keys);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node<Key, Value> node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            midErgodic(node.left, keys);
        }
        keys.enqueue(node.key);
        if (node.right != null) {
            midErgodic(node.right, keys);
        }
    }

    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node<Key, Value> node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            afterErgodic(node.left, keys);
        }
        if (node.right != null) {
            afterErgodic(node.right, keys);
        }
        keys.enqueue(node.key);
    }

    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<>();
        Queue<Node<Key, Value>> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node<Key, Value> dequeue = nodes.dequeue();
            keys.enqueue(dequeue.key);
            if (dequeue.left != null) {
                nodes.enqueue(dequeue.left);
            }
            if (dequeue.right != null) {
                nodes.enqueue(dequeue.right);
            }
        }
        return keys;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node<Key, Value> node) {
        if (node == null) return 0;
        int max, maxLeft = 0, maxRight = 0;
        if (node.left != null) {
            maxLeft = maxDepth(node.left);
        }
        if (node.right != null) {
            maxRight = maxDepth(node.right);
        }
        max = maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
        return max;
    }

}
