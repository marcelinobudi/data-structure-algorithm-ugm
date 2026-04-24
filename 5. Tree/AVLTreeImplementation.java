import avl_tree.AVLTree;

public class AVLTreeImplementation {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values1 = {10, 20, 30, 40, 50, 25}; // These would make a BST look like a line.

        for (int v : values1) {
            tree.insert(v);
        }

        System.out.print("AVL In-Order Traversal After Insertion: ");
        tree.displayInOrder(tree.root); // Output: 10 20 25 30 40 50

        int[] values2 = {15, 60, 35};

        for (int v : values2) {
            tree.insert(v);
        }

        System.out.print("\nAVL In-Order Traversal After Insertion: ");
        tree.displayInOrder(tree.root);

        tree.delete(30);

        System.out.print("\nAVL In-Order Traversal After Deletion: ");
        tree.displayInOrder(tree.root);
        System.out.println(); // Final newline
    }
}
