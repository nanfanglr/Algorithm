package com.rui.algorithm.graph;

public class Edge implements Comparable<Edge> {
    private final int from;
    private final int to;
    private final double weight;

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return to;
    }

    public int other(int vertex) {
        return vertex == from ? to : from;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight(), that.weight);
    }
}


