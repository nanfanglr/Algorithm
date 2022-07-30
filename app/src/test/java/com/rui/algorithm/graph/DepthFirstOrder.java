package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        reversePost = new Stack<>();
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer integer : G.adj[v]) {
            if (!marked[integer]) {
                dfs(G, integer);
            }
        }
        reversePost.push(v);
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
