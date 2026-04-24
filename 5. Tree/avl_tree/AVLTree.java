package avl_tree;

import javax.print.DocFlavor.READER;

class Node{
    int data;
    Node left, right;
    int height;

    Node(int data){
        this.data = data;
        this.height = 1;
    }
}

public class AVLTree {
    public Node root = null;

    boolean isEmpty(){
        return root == null;
    }

    int getHeight(Node node){
        return (node!= null) ? node.height : 0;
    }

    int getBalance(Node node) {
        if(node==null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // gerak dari kiri ke kanan
    Node rotateRight(Node b){
        Node a = b.left;
        Node temp = a.right;

        a.right = b;
        b.left = temp;

        b.height = 1 + Math.max(getHeight(b.left), getHeight(b.right));
        a.height = 1 + Math.max(getHeight(a.left), getHeight(a.right));

        return a;
    }

    Node rotateLeft(Node b){
        Node a = b.right;
        Node temp = a.left;

        b.right = temp;
        a.left = b;

        a.height = 1 + Math.max(getHeight(a.left), getHeight(a.right));
        b.height = 1 + Math.max(getHeight(b.left), getHeight(b.right));

        return a;
    }

    public void insert(int data){
        root = insertRecursive(root, data);
    }
    private Node insertRecursive(Node current, int data){
        if(current == null){
            return new Node(data);
        }
        if(data < current.data){
            current.left = insertRecursive(current.left, data);
        } else{
            current.right = insertRecursive(current.right, data);
        }

        current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));
        int balance = getBalance(current);

        // Left-heavy case
        if(balance > 1){
            // cek, data yg baru aja di-insert itu ada di left sub-tree atau di right sub-tree
            if(data < current.left.data){
                return rotateRight(current);
            } else {
                current.left = rotateLeft(current.left); // rotasiin dulu left subtree supaya jadi left-left case
                return rotateRight(current); // ini nanti menjadi kasus left-left case!! langsung saja rotate right
            }
        }
        // Right heavy
        if(balance < -1){
            if(data >= current.right.data){
                return rotateLeft(current);
            } else {
                current.right = rotateRight(current.right);
                return rotateLeft(current);
            }
        }

        return current;
    }

    public Node getMinValueNode(Node node){
        if(node.left == null){
            return node;
        }
        return getMinValueNode(node.left);
    }

    public void delete (int data){
        root = deleteRecursive(root, data);
    }

    private Node deleteRecursive(Node current, int data){
        if(current == null) {
            return null;
        }

        if(data < current.data){
            current.left = deleteRecursive(current.left, data);
        } else if(current.data < data){
            current.right = deleteRecursive(current.right, data);
        } else {
            if(current.left == null){
                return current.right;
            }
            else if(current.right == null) {
                return current.left;
            }

            Node successor = getMinValueNode(current.right);
            current.data = successor.data;
            current.right = deleteRecursive(current.right, successor.data);
        }
        
        // SAFETY chek
        if(current == null){
            return current;
        }

        current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));
        int balance = getBalance(current);

        // left heavy
        if(balance > 1){
            if(getBalance(current.left) >= 0){
                return rotateRight(current);
            } else{
                current.left = rotateLeft(current.left);
                return rotateRight(current);
            }
        }

        if(balance < -1){
            if(getBalance(current.right) <= 0) {
                return rotateLeft(current);
            } else{
                current.right = rotateLeft(current.right);
                return rotateLeft(current);
            }
        }

        return current;
    }

    public void displayInOrder(Node node){
        if(node != null){
            displayInOrder(node.left);
            System.out.print(node.data + " ");
            displayInOrder(node.right);
        }
    }
}
