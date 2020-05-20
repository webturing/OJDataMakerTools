package zj.ojd.ds;

import java.util.List;
import java.util.Map;

public class UnDirectedGraph implements   Graph{
    @Override
    public int[][] getMatrix() {
        return new int[0][];
    }

    @Override
    public Map<Vertex, List<Vertex>> getAdjacentTable() {
        return null;
    }

    @Override
    public List<Edge> getEdges() {
        return null;
    }

    @Override
    public void addEdge(Edge e) {

    }

    @Override
    public void removeEdge() {

    }

    @Override
    public List<Vertex> getVertexs() {
        return null;
    }

    @Override
    public void addVertex(Vertex v) {

    }

    @Override
    public void removeVertex(Vertex v) {

    }
}
