import java.util.Arrays;

public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size]; // menyimpan depth, berguna untuk menjaga keseimbangan. Ingat, ini depth, BUKAN JUMLAH ANAK

        /*
         * setiap elemen, parentnya adalah diri sendiri
         * kedalamannya adalah 0
         * */
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if(parent[node] != node) {
            /**
             * Saat mencari node, kita sekaligus update parentnya.
             * INGAT Kelas Teori: ada yg mengatur supaya parentnya langsung nunjuk ke root supaya mempercepat pencarian
             */
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    // object return P(x) = 'x berhasil union'
    public boolean union(int x, int y) {
        int rootX = find(x); // caching.
        int rootY = find(y);

        /**
         * Syarat union adalah root tidak boleh sama.
         * yg depthnya kecil, nempel ke yg depthnya besar
         */
        if(rootX == rootY) return false;
        if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if(rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++; /** JANGAN LUPAKAN*/
        }
        return true;
    }

    public void printParents() {
        System.out.println(Arrays.toString(parent));
    }
}
