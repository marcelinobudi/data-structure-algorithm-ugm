import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Prim menggunakan representasi Adjacent List (target, weigth). Buat Edge(target, weight)
 * butuh
 * - sesuatu yg merepresentasikan IS_IN_MST
 * - method yg bisa langsung dapet target dengan minimum weight
 *
 * GW GA PAHAM SAMSEK, mekanisme pencarian next node nya rumit
 */
public class Graph {
    int V;
    List<Edge>[] adjList;

    public Graph(int v) {
        V = v;
        adjList = new List[V];
        Arrays.fill(adjList, new ArrayList<Edge>());
    }

    public void addEdge(int source, int target, int weight) {
        adjList[source].add(new Edge(target, weight));
        adjList[target].add(new Edge(source, weight));
        System.out.println(source + " " + new Edge(target, weight));
    }

    public void findMSTPrim(int start) {
        int[] weights = new int[V];
        int[] parent = new int[V];
        boolean[] inMST = new boolean[V];

        Arrays.fill(weights, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        weights[start] = 0;

        PriorityQueue<NodePrim> nodeTargets = new PriorityQueue<>();
        nodeTargets.add(new NodePrim(start, 0));

        while(!nodeTargets.isEmpty()) {
            int source = nodeTargets.poll().vertex;
            inMST[source] = true;

            for(Edge edge: adjList[source]) {
                int target = edge.target;
                int weight = edge.weight;

                if(!inMST[target] && weight < weights[target]) {
                    weights[target] = weight;
                    parent[target] = source;
                    nodeTargets.add(new NodePrim(target, weight));
                }
            }
        }

        for(int i = 0; i<V; i++) {
            System.out.println(parent[i] + " - " + i + " \t" + weights[i]);
        }
    }
}
