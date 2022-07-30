package com.rui.algorithm.tree;

import com.rui.algorithm.lineartable.Queue;

import org.junit.Test;

public class PaperFolding {

    @Test
    public void testPaperFolding() {
        Node tree = createTree(3);
        printTree(tree);
    }

    private void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println(node.item + ",");
        printTree(node.right);
    }

    private Node createTree(int N) {
        Node root = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                root = new Node("down", null, null);
            } else {
                Queue<Node> queue = new Queue<>();
                queue.enqueue(root);
                while (!queue.isEmpty()) {
                    Node dequeue = queue.dequeue();
                    if (dequeue.left != null) {
                        queue.enqueue(dequeue.left);
                    }
                    if (dequeue.right != null) {
                        queue.enqueue(dequeue.right);
                    }
                    if (dequeue.left == null && dequeue.right == null) {
                        dequeue.left = new Node("down", null, null);
                        dequeue.right = new Node("up", null, null);
                    }
                }

            }
        }
        return root;
    }

    private class Node {
        String item;
        Node left;
        Node right;

        public Node(String item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
