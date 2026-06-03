import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * CATAT
 * Comparator.comparingInt
 */

public class Graph {
    int V, E;
    DisjointSet unionSet;
    PriorityQueue<Edge> edges = new PriorityQueue<>();

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        unionSet = new DisjointSet(V);
    }

    public void addEdge(int source, int target, int weight) {
        edges.add(new Edge(source, target, weight));
        edges.add(new Edge(target, source, weight));
    }

    public List<Edge> findMSTKruskal() {
        List<Edge> MST = new ArrayList<>();
        for (Edge e : edges) {
            if(unionSet.union(e.source, e.target)){
                MST.add(e);
            }
        }
        return MST;
    }
}
