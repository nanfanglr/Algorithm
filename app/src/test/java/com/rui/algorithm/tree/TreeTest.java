package com.rui.algorithm.tree;

import com.rui.algorithm.lineartable.Queue;

import org.junit.Test;

public class TreeTest {

    @Test
    public void testBinaryTree() {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        System.out.println("max = " + bt.max());
        System.out.println("min = " + bt.min());
        bt.put(1, "老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());

    }

    @Test
    public void testBinaryTreePreErgodic() {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.preErgodic();
        for (String key : queue) {
            System.out.println(key + "=" + bt.get(key));
        }
    }

    @Test
    public void testBinaryTreeMidErgodic() {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.midErgodic();
        for (String key : queue) {
            System.out.println(key + "=" + bt.get(key));
        }
    }

    @Test
    public void testBinaryTreeAfterErgodic() {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.afterErgodic();
        for (String key : queue) {
            System.out.println(key + "=" + bt.get(key));
        }
    }

    @Test
    public void testLayerErgodic() {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.layerErgodic();
        for (String key : queue) {
            System.out.println(key + "=" + bt.get(key));
        }
    }

    @Test
    public void testMaxDepth() {
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        int depth = bt.maxDepth();
        System.out.println("depth =" + depth);
    }

    @Test
    public void testRedBlackTree() {
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        tree.put(4, "four");
        tree.put(1, "one");
        tree.put(3, "three");
        tree.put(5, "five");
        System.out.println("1 = " + tree.get(1));
        System.out.println("size = " + tree.size());
        tree.put(1, "oonnee");
        System.out.println("1 = " + tree.get(1));
        System.out.println("size = " + tree.size());
    }

    @Test
    public void testUFTree() {
        UF uf = new UF(7);
        uf.union(0, 2);
        uf.union(2, 4);
        uf.union(3, 5);
        uf.union(5, 6);
        System.out.println("总共还有" + uf.count() + "个分组");
        System.out.println("3 connect 5 = " + uf.connect(3, 5));
        System.out.println("3 connect 0 = " + uf.connect(3, 0));
    }

    @Test
    public void testUF_Tree() {
        UF_Tree uf = new UF_Tree(7);
        uf.union(0, 2);
        uf.union(2, 4);
        uf.union(3, 5);
        uf.union(5, 6);
        System.out.println("总共还有" + uf.count() + "个分组");
        System.out.println("3 connect 5 = " + uf.connected(3, 5));
        System.out.println("3 connect 0 = " + uf.connected(3, 0));
    }

    @Test
    public void testUF_Tree_Weighted() {
        UF_Tree_Weighted uf = new UF_Tree_Weighted(7);
        uf.union(0, 2);
        uf.union(2, 4);
        uf.union(3, 5);
        uf.union(5, 6);
        System.out.println("总共还有" + uf.count() + "个分组");
        System.out.println("3 connect 5 = " + uf.connected(3, 5));
        System.out.println("3 connect 0 = " + uf.connected(3, 0));
    }

    @Test
    public void testUF_Tree_Weighted_Traffic() {
        UF_Tree_Weighted uf = new UF_Tree_Weighted(20);
        uf.union(0, 1);
        uf.union(6, 9);
        uf.union(3, 8);
        uf.union(5, 11);
        uf.union(2, 12);
        uf.union(6, 10);
        uf.union(4, 8);
        int groupNumber = uf.count();
        System.out.println("还要修建" + (groupNumber - 1) + "条公路才能通");
    }


}
