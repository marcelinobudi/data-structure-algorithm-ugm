public class NodePrim implements Comparable<NodePrim>{
    public int vertex;
    public int weight;


    public NodePrim(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(NodePrim nodePrim) {
        return Integer.compare(this.weight, nodePrim.weight);
    }
}
