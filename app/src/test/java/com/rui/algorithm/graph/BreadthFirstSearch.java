package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        waitSearch = new Queue<>();
        bfs(G, s);
    }

    private void bfs(Graph g, int v) {
        waitSearch.enqueue(v);
        marked[v] = true;
        while (!waitSearch.isEmpty()) {
            Integer w = waitSearch.dequeue();
            count++;
            for (Integer s : g.adj(w)) {
                if (!marked[s]) {
                    waitSearch.enqueue(s);
                    marked[s] = true;
                }
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
