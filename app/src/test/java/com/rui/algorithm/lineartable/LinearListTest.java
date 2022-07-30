package com.rui.algorithm.lineartable;

import org.junit.Test;

public class LinearListTest {

    @Test
    public void testSequenceList() {
        SequenceList<String> s1 = new SequenceList<>(100);
        s1.insert("1111");
        s1.insert("2222");
        s1.insert("3333");
        s1.insert("4444");

        String getResult = s1.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);

        int indexResult = s1.indexOf("3333");
        System.out.println("获取索引indexResult结果为：" + indexResult);

        String removeResult = s1.remove(0);
        System.out.println("获取索引1处的结果为：" + removeResult);

        s1.clear();
        System.out.println("清空后的线性表中的元素个数为：" + s1.length());
    }

    @Test
    public void testSequenceListIterable() {
        SequenceList<String> s1 = new SequenceList<>(100);
        s1.insert("1111");
        s1.insert("2222");
        s1.insert("3333");
        s1.insert("4444");
        for (String s : s1) {
            //sout
            System.out.println(s);
        }
    }

    @Test
    public void testSequenceListResize1() {
        SequenceList<String> s1 = new SequenceList<>(4);
        s1.insert("1111");
        s1.insert("2222");
        s1.insert("3333");
        s1.insert("4444");
        s1.insert("5555");
        System.out.println("capacity = " + s1.capacity());
        s1.showElements();
    }

    @Test
    public void testSequenceListResize2() {
        SequenceList<String> s1 = new SequenceList<>(12);
        s1.insert("1111");
        s1.insert("2222");
        s1.insert("3333");
        s1.insert("4444");
        s1.insert("5555");
        s1.insert("6666");
        s1.insert("7777");
        s1.insert("8888");
        s1.remove(0);
        s1.showElements();
        s1.remove(0);
        s1.showElements();
        s1.remove(0);
        s1.showElements();
        s1.remove(0);
        s1.showElements();
        s1.remove(0);
        s1.showElements();
        s1.remove(0);
        s1.showElements();
        System.out.println("capacity = " + s1.capacity());
        s1.showElements();
    }

    @Test
    public void testCreateNode() {
        Node<Integer> first = new Node<>(11, null);
        Node<Integer> second = new Node<>(22, null);
        Node<Integer> third = new Node<>(33, null);
        Node<Integer> fourth = new Node<>(44, null);
        Node<Integer> fifth = new Node<>(55, null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
    }

    @Test
    public void testLinkList() {
        LinkList<String> list = new LinkList<>();
        list.insert(0, "0000");
        list.insert(1, "1111");
        list.insert(2, "2222");
        list.insert(3, "3333");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("----------------------");
        System.out.println(list.get(2));
        System.out.println("----------------------");
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------------");
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testLinkListReverse() {
        LinkList<Integer> list = new LinkList<>();
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        for (int s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        list.reverse();
        for (int s : list) {
            System.out.println(s);
        }
    }


    @Test
    public void testTowWayLinkList() {
        TowWayLinkList<String> list = new TowWayLinkList<>();
        list.insert("0000");
        list.insert("1111");
        list.insert("2222");
        list.insert("3333");
        list.insert(1, "11111");
        list.insert(3, "33333");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.length());
        System.out.println("----------------------");
        System.out.println(list.get(2));
        System.out.println("----------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

    @Test
    public void testJosephe() {
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            if (i == 1) {
                first = new Node<>(1, null);
                pre = first;
                continue;
            }
            Node<Integer> node = new Node<>(i, null);
            pre.next = node;
            pre = node;
            if (i == 41) {
                pre.next = first;
            }
        }

        int count = 0;
        Node<Integer> before = null;
        Node<Integer> n = first;

        while (n != n.next) {
            count++;
            if (count == 3) {
                before.next = n.next;
                System.out.print(n.item + ",");
                count = 0;
                n = n.next;
            } else {
                before = n;
                n = n.next;
            }
        }
        System.out.println("剩下的人为：" + n.item);
    }

    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("--------------------------------");
        String pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack.size());
        for (String s : stack) {
            System.out.println(s);
        }
    }

    @Test
    public void testQueue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String str : queue) {
            System.out.print(str + " ");
        }
        System.out.println("-----------------------------");
        String result = queue.dequeue();
        System.out.println("出列了元素:" + result);
        System.out.println(queue.size());
    }

}
