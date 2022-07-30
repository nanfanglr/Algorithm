package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;
import com.rui.algorithm.priorityqueue.MinPriorityQueue;
import com.rui.algorithm.tree.UF_Tree_Weighted;

public class KruskalMST {
    private Queue<Edge> mst;
    private UF_Tree_Weighted uf;
    private MinPriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph G) {
        this.mst = new Queue<>();
        this.uf = new UF_Tree_Weighted(G.V());
        this.pq = new MinPriorityQueue<>(G.E() + 1);
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge edge = pq.deleteMin();
            int v = edge.either();
            int w = edge.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(edge);
        }
    }

    public Queue<Edge> edges() {
        return mst;
    }
}
