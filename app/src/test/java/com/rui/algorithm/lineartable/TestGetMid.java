package com.rui.algorithm.lineartable;

import org.junit.Test;

public class TestGetMid {

    @Test
    public void testGetMid() {
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        String mid = getMid(first);
        System.out.println("中间值为：" + mid);

    }

    private String getMid(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item,   Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
