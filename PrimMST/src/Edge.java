public class Edge{
    public int target;
    public int weight;


    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge("+target+","+weight+")";
    }
}
