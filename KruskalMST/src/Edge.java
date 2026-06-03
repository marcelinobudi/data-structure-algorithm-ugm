public class Edge implements Comparable<Edge>{
    public int source;
    public int target;
    public int weight;


    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }

    // HANYA UNTUK BELAJAR

    @Override
    public String toString() {
        return "Edge("+source+", "+target+", "+weight+")";
    }
}
