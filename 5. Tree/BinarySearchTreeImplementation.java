import binary_search_tree.Node;
import binary_search_tree.BinarySearchTree;


public class BinarySearchTreeImplementation {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(8);
        tree.addNode(7);
        
        tree.addNode(4);
        
        System.out.println(tree.minValue());
        System.out.println(tree.maxValue());
        System.out.println();
        BinarySearchTree.preOrder(tree.root); // pre order sangat berguna ketika ingin melakukan copy paste struktur tree karena mengunjungi parentnya dulu
        System.out.println();
        System.out.println(tree.root.right.right.left.value);
        System.out.println();
        BinarySearchTree.postOrder(tree.root); // berguna ketika ingin menghapus, pastikan anak-anaknya dulu dihapus baru ayahnya.
                                                // berguna juga untuk `disk usage` command: menghitung ukuran folder
        System.out.println();
        BinarySearchTree.inOrder(tree.root); // menghasilkan angka terurut
        System.out.println();
        System.out.println(tree.searchValue(7));
    }
    
}
