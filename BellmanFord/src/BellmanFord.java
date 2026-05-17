import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static void getShortestPath(ArrayList<Edge> edges, int V, int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for(int counter = 1; counter < V; counter++) { // abaikan variable counter, yg penting iterasinya sebanyak |V| - 1 kali!
            for(int i = 0; i < edges.size(); i++) {
                int from = edges.get(i).source;
                int to = edges.get(i).destination;
                int weight = edges.get(i).weight;
                if(distance[from] != Integer.MAX_VALUE && distance[from] + weight < distance[to]) {
                    distance[to] = distance[from] + weight;
                }
            }
        }

        if(isGraphContainingNegativeCycle(edges, distance)) {
            System.out.println("Graph contains Negative Cycle!");
            return;
        }
        System.out.println("DISTANCE");
        for(int i = 0; i < V; i++) {
            System.out.println(String.format("%s to %s = %s", source, i, distance[i]));
        }
    }

    public static boolean isGraphContainingNegativeCycle(ArrayList<Edge> edges, int[] distance) {
        for(int i = 0; i < edges.size(); i++) {
            int from = edges.get(i).source;
            int to = edges.get(i).destination;
            int weight = edges.get(i).weight;
            if(distance[from] != Integer.MAX_VALUE && distance[from] + weight < distance[to]) {
                return true;
            }
        }
        return false;
    }
}
