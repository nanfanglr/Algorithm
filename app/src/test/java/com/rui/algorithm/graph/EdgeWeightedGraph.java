package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
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

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].enqueue(edge);
        adj[w].enqueue(edge);
        E++;
    }

    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    public Queue<Edge> edges() {
        Queue<Edge> allEdges = new Queue<>();
        for (int v = 0; v < this.V; v++) {
            for (Edge edge : adj(v)) {
                if (edge.other(v) < v) {
                    allEdges.enqueue(edge);
                }
            }
        }
        return allEdges;
    }
}
