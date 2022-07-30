package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;

public class Digraph {
    private final int V;
    private int E;
    public Queue<Integer>[] adj;

    public Digraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int l, int r) {
        adj[l].enqueue(r);
        E++;
    }

    private Digraph reverse() {
        Digraph digraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer integer : adj[v]) {
                digraph.addEdge(integer, v);

            }
        }
        return digraph;
    }
}
