import binary_search_tree.BinarySearchTree;


public class BinarySearchTreeImplementation {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(8);
        bst.addNode(3);
        bst.addNode(1);
        bst.addNode(6);
        bst.addNode(4);
        bst.addNode(7);
        bst.addNode(10);
        bst.addNode(14);
        bst.addNode(13);

        System.out.println("PreOrder: Root - left - right");
        BinarySearchTree.preOrder(bst.root);
        System.out.println();
        System.out.println("PostOrder: left-right-root");
        BinarySearchTree.postOrder(bst.root);
        System.out.println();
        System.out.println("InOrder: Left-root-right");
        BinarySearchTree.inOrder(bst.root);
        System.out.println();

        System.out.println("Search");
        System.out.println(bst.searchValue(3));

        System.out.println("Delete");
        bst.delete(4);

        System.out.println("PreOrder: Root - left - right");
        BinarySearchTree.preOrder(bst.root);
        System.out.println();
        System.out.println("PostOrder: left-right-root");
        BinarySearchTree.postOrder(bst.root);
        System.out.println();
        System.out.println("InOrder: Left-root-right");
        BinarySearchTree.inOrder(bst.root);
        System.out.println();

    }

    private static void experiment(){
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
        BinarySearchTree.postOrder(tree.root); // berguna ketika ingin menghapus, pastikan anak-anaknya dulu dihapus baru parentnya.
                                                // berguna juga untuk `disk usage` command: menghitung ukuran folder
        System.out.println();
        BinarySearchTree.inOrder(tree.root); // menghasilkan angka terurut
        System.out.println();
        System.out.println(tree.searchValue(7));
    }
    
}
