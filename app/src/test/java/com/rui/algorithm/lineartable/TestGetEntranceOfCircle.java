package com.rui.algorithm.lineartable;

import org.junit.Test;

public class TestGetEntranceOfCircle {

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
        seventh.next = third;

        Node<String> entrance = getEntrance(first);
        System.out.println("链表环入口：" + entrance.item);
    }

    private Node<String> getEntrance(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                temp = first;
                continue;
            }
            if (temp != null) {
                temp = temp.next;
                if (temp.equals(slow)) {
                    return temp;
                }
            }
        }
        return null;
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
