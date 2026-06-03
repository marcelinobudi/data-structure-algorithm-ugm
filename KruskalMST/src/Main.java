import java.util.List;

public class Main {
    public static void main(String[] args) {
        int V = 5;
        int E = 7;

        Graph g = new Graph(V, E);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        List<Edge> MST = g.findMSTKruskal();
        System.out.println(MST.toString());
    }
}
