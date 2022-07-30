package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Queue<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
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

    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        adj[v].enqueue(edge);
        E++;
    }

    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Queue<DirectedEdge> edges() {
        Queue<DirectedEdge> directedEdges = new Queue<>();
        for (int i = 0; i < this.V; i++) {
            for (DirectedEdge directedEdge : adj[i]) {
                directedEdges.enqueue(directedEdge);
            }
        }
        return directedEdges;
    }
}
