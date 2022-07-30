package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Stack;

public class DepthFirstPaths {
    private boolean marked[];
    private int s;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);

    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (Integer integer : g.adj(v)) {
            if (!marked[integer]) {
                edgeTo[integer] = v;
                dfs(g, integer);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> paths = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            paths.push(x);
        }
        paths.push(s);
        return paths;
    }
}
