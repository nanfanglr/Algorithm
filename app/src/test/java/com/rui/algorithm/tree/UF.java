package com.rui.algorithm.tree;

public class UF {
    private int[] eleAndGroup;
    private int count;

    public UF(int N) {
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
        return eleAndGroup[p];
    }

    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        if (connect(p, q)) {
            return;
        }
        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        count--;
    }
}
