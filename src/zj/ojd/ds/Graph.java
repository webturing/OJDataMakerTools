package zj.ojd.ds;


import java.util.List;
import java.util.Map;

public interface Graph {
    String toString();

    int[][] getMatrix();

    Map<Vertex, List<Vertex>> getAdjacentTable();


    List<Edge> getEdges();

    void addEdge(Edge e);

    void removeEdge();

    List<Vertex> getVertexs();

    void addVertex(Vertex v);

    void removeVertex(Vertex v);


}
