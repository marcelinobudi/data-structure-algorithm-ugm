import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(4, 3, -3));

        int V = 5;                  // No of vertices.

        BellmanFord.getShortestPath(edges, V, 0);
    }
}
