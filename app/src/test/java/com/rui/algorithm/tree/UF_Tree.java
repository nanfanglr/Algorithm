package com.rui.algorithm.tree;

import com.rui.algorithm.priorityqueue.PriorityQueueTest;

public class UF_Tree {
    private int[] eleAndGroup;
    private int count;

    public UF_Tree(int N) {
        this.count = N;
        eleAndGroup = new int[N];
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (true) {
            if (p == eleAndGroup[p]) {
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        eleAndGroup[pRoot] = qRoot;
        count--;
    }
}
