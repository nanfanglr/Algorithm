package com.rui.algorithm.graph;

import com.rui.algorithm.lineartable.Queue;
import com.rui.algorithm.lineartable.Stack;

import org.junit.Test;

public class GraphTest {
    @Test
    public void testDepthFirst() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println("与定点0相通的数量为：" + depthFirstSearch.count());
        //测试某个点与定点是否相通
        System.out.println("与定点0是否相通：" + depthFirstSearch.marked(5));
        System.out.println("与定点0是否相通：" + depthFirstSearch.marked(7));
    }

    @Test
    public void testBreadthFirst() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        BreadthFirstSearch depthFirstSearch = new BreadthFirstSearch(graph, 0);
        System.out.println("与定点0相通的数量为：" + depthFirstSearch.count());
        //测试某个点与定点是否相通
        System.out.println("与定点0是否相通：" + depthFirstSearch.marked(5));
        System.out.println("与定点0是否相通：" + depthFirstSearch.marked(7));
    }

    @Test
    public void testTraffic() {
        Graph graph = new Graph(20);
        graph.addEdge(0, 1);
        graph.addEdge(6, 9);
        graph.addEdge(3, 8);
        graph.addEdge(5, 11);
        graph.addEdge(2, 12);
        graph.addEdge(6, 10);
        graph.addEdge(4, 8);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, 9);
        boolean ten = breadthFirstSearch.marked(10);
        boolean eight = breadthFirstSearch.marked(8);
        System.out.println("9号城市是否和10号相通:" + ten);
        System.out.println("9号城市是否和8号相通:" + eight);
    }

    @Test
    public void testDepthFirstPaths() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 0);
        Stack<Integer> path = depthFirstPaths.pathTo(4);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : path) {
            sb.append(integer + "-");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    @Test
    public void tesDirectedCycle() {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(3, 0);
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 1);
        digraph.addEdge(1, 0);
        digraph.addEdge(1, 4);
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        System.out.println(directedCycle.hasCycle());
    }


    @Test
    public void tesTopoLogical() {
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(1, 3);
        TopoLogical topoLogical = new TopoLogical(digraph);
        Stack<Integer> order = topoLogical.order();
        StringBuilder sb = new StringBuilder();
        for (Integer integer : order) {
            sb.append(integer).append("->");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    @Test
    public void testPrimMST() {

        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(8);
        edgeWeightedGraph.addEdge(new Edge(4, 5, 0.35));
        edgeWeightedGraph.addEdge(new Edge(4, 7, 0.37));
        edgeWeightedGraph.addEdge(new Edge(5, 7, 0.28));
        edgeWeightedGraph.addEdge(new Edge(0, 7, 0.16));
        edgeWeightedGraph.addEdge(new Edge(1, 5, 0.32));
        edgeWeightedGraph.addEdge(new Edge(0, 4, 0.38));
        edgeWeightedGraph.addEdge(new Edge(2, 3, 0.17));
        edgeWeightedGraph.addEdge(new Edge(1, 7, 0.19));
        edgeWeightedGraph.addEdge(new Edge(0, 2, 0.26));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 0.36));
        edgeWeightedGraph.addEdge(new Edge(1, 3, 0.29));
        edgeWeightedGraph.addEdge(new Edge(2, 7, 0.34));
        edgeWeightedGraph.addEdge(new Edge(6, 2, 0.40));
        edgeWeightedGraph.addEdge(new Edge(3, 6, 0.52));
        edgeWeightedGraph.addEdge(new Edge(6, 0, 0.58));
        edgeWeightedGraph.addEdge(new Edge(6, 4, 0.93));
        PrimMST primMST = new PrimMST(edgeWeightedGraph);
        Queue<Edge> edges = primMST.edges();

        for (Edge edge : edges) {
            if (edge != null) {
                System.out.println(edge.either() + "-" + edge.other(edge.either()) + "::" + edge.weight());
            }
        }
    }

    @Test
    public void testKruskalMST() {

        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(8);
        edgeWeightedGraph.addEdge(new Edge(4, 5, 0.35));
        edgeWeightedGraph.addEdge(new Edge(4, 7, 0.37));
        edgeWeightedGraph.addEdge(new Edge(5, 7, 0.28));
        edgeWeightedGraph.addEdge(new Edge(0, 7, 0.16));
        edgeWeightedGraph.addEdge(new Edge(1, 5, 0.32));
        edgeWeightedGraph.addEdge(new Edge(0, 4, 0.38));
        edgeWeightedGraph.addEdge(new Edge(2, 3, 0.17));
        edgeWeightedGraph.addEdge(new Edge(1, 7, 0.19));
        edgeWeightedGraph.addEdge(new Edge(0, 2, 0.26));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 0.36));
        edgeWeightedGraph.addEdge(new Edge(1, 3, 0.29));
        edgeWeightedGraph.addEdge(new Edge(2, 7, 0.34));
        edgeWeightedGraph.addEdge(new Edge(6, 2, 0.40));
        edgeWeightedGraph.addEdge(new Edge(3, 6, 0.52));
        edgeWeightedGraph.addEdge(new Edge(6, 0, 0.58));
        edgeWeightedGraph.addEdge(new Edge(6, 4, 0.93));
        KruskalMST primMST = new KruskalMST(edgeWeightedGraph);
        Queue<Edge> edges = primMST.edges();

        for (Edge edge : edges) {
            if (edge != null) {
                System.out.println(edge.either() + "-" + edge.other(edge.either()) + "::" + edge.weight());
            }
        }
    }

    @Test
    public void testDijkstraSp() {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new DirectedEdge(4, 5, 0.35));
        digraph.addEdge(new DirectedEdge(5, 4, 0.35));
        digraph.addEdge(new DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new DirectedEdge(7, 5, 0.28));
        digraph.addEdge(new DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new DirectedEdge(0, 4, 0.38));
        digraph.addEdge(new DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new DirectedEdge(7, 3, 0.39));
        digraph.addEdge(new DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new DirectedEdge(2, 7, 0.34));
        digraph.addEdge(new DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new DirectedEdge(6, 4, 0.93));

        DijkstraSP dijkstraSP = new DijkstraSP(digraph, 0);
        Queue<DirectedEdge> directedEdges = dijkstraSP.pathTo(6);

        for (DirectedEdge directedEdge : directedEdges) {
            System.out.println(directedEdge.from() + "->" + directedEdge.to() + "::" + directedEdge.weight());
        }

    }


}
