public class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);

        // Perform some union operations
        ds.union(0, 2);
        //ds.union(4, 2);
        ds.union(4, 1);
        ds.union(3, 1);

        // Print results to see the relationships
        ds.printParents();

        // Check if two elements belong to the same set
        System.out.println("Are 0 and 4 in the same set? " + (ds.find(0) == ds.find(4)));
    }
}
