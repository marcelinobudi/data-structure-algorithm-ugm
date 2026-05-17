public class Main {
    public static void main(String[] args) {
        int graph[][] = new int[][] {		// Adcajency matrix.
                {0, 2, 1, 4, 5, 1},
                {1, 0, 4, 2, 3, 4},
                {2, 1, 0, 1, 2, 4},
                {3, 5, 2, 0, 3, 3},
                {2, 4, 3, 4, 0, 1},
                {3, 4, 7, 3, 1, 0}
        };
        Dijkstra.getShortestPath(graph, 0);
    }

}
