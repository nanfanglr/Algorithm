package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;
import com.rui.algorithm.priorityqueue.IndexMinPriorityQueue;

import java.util.Arrays;

public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPriorityQueue<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        this.edgeTo = new Edge[G.V()];
        this.distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        this.marked = new boolean[G.V()];
        this.pq = new IndexMinPriorityQueue<>(G.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.deleteMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int V) {
        marked[V] = true;
        for (Edge edge : G.adj(V)) {
            int w = edge.other(V);
            if (marked[w]) {
                continue;
            }
            if (edge.weight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if (pq.contains(w)) {
                    pq.changeItem(w, edge.weight());
                } else {
                    pq.insert(w, edge.weight());
                }
            }
        }
    }

    public Queue<Edge> edges() {
        Queue<Edge> edges = new Queue<>();
        for (int i = 0; i < marked.length; i++) {
            if (edgeTo[i] != null) {
                edges.enqueue(edgeTo[i]);
            }
        }
        return edges;
    }

}
