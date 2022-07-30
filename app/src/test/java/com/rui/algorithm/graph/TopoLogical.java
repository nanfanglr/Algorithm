package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Stack;

public class TopoLogical {
    private Stack<Integer> order;

    public TopoLogical(Digraph G) {
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    private boolean isCycle() {
        return order == null;
    }

    public Stack<Integer> order() {
        return order;
    }
}
