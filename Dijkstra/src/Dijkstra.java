import java.util.Arrays;

public class Dijkstra {
    public static void getShortestPath(int[][] graph, int source){
        int[] distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length]; // automatically false

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // iterasi sebanyak |V|, sampai seluruh elemen V ditandai 'visited'
        for(int counter = 0; counter < graph.length; counter++) {
            int minVertex = getMinimumVertexFromDistanceArray(distance, visited);
            visited[minVertex] = true;
            for(int target = 0; target < graph.length; target++){
                int newDistance = graph[minVertex][target] + distance[minVertex];
                if(!visited[target] && newDistance < distance[target]){
                    // Relaxation, update distance
                    distance[target] = newDistance;
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }

    /// dapatkan vertex yg jaraknya terendah di array distance
    private static int getMinimumVertexFromDistanceArray(int[] distance, boolean[] visited){
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
}
