package avl_tree;

public class AVLTree{
    public Node root = null;
    public boolean isEmpty(){
        return root == null;
    }

    int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    int getBF(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
        // ini adalah kasus dimana height dimulai dari 0.
        // perhitungan jadi sangat kompleks!!
        // height dari suatu node yg tidak memiliki child haruslah bernilai satu untuk mempermudah perhitungan

        // if(node.left == null && node.right != null){
        //     return -(getHeight(node.right)+1);
        // } 
        // if(node.left != null && node.right == null){
        //     return getHeight(node.left) + 1;
        // }
        // return getHeight(node.left) - getHeight(node.right);
    }

    Node rotateRight(Node A){
        Node B = A.left;
        A.left = B.right;
        B.right = A;

        B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right)); // update height
        A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
        return B;
    }

    Node rotateLeft(Node A){
        Node B = A.right;
        A.right = B.left;
        B.left = A;
        
        B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));
        A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
        return B;
    }

    public void insert(int data){
        root = insertR(root, data);
    }
    Node insertR(Node current, int data){
        if(current == null){
            return new Node(data);
        } 
        if(data < current.data){
            current.left = insertR(current.left, data);
        } else if(data >= current.data){
            current.right = insertR(current.right, data);
        }

        // refresh height
        current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));

        int bf = getBF(current);
        if(bf > 1){
            // LL Case
            if(data < current.left.data){
                current = rotateRight(current);
            } else{
                current.left = rotateLeft(current.left);
                current = rotateRight(current);
            }
        } else if(bf < -1){
            if(data >= current.right.data){
                current = rotateLeft(current);
            } else {
                current.right = rotateRight(current.right);
                current = rotateLeft(current);
            }
        }

        return current;
    }
    public void displayInOrder(Node current){
        if(current == null){
            return;
        }
        displayInOrder(current.left);
        System.out.print(current.data + " ");
        displayInOrder(current.right);
    }

    int findMinimumValue(Node current){
        if(current.left == null){
            return current.data;
        }
        return findMinimumValue(current.left);
    }

    public void delete(int data){
        root = deleteR(root, data);
    }

    Node deleteR(Node current, int data){
        if(current == null){
            return null;
        }

        if(data < current.data){
            current.left = deleteR(current.left, data);
        } else if(data > current.data){
            current.right = deleteR(current.right, data);
        } else{
            if(current.left == null){
                return current.right;
            } else if(current.right == null){
                return current.left;
            } 
            int successor = findMinimumValue(current.right);
                current.data = successor;
                current.right = deleteR(current.right, successor);
            
        }

        if(current == null){
            return null;
        }

        current.height = 1+Math.max(getHeight(current.left), getHeight(current.right));
        int bf = getBF(current);
        if(bf > 1){
            // LL Case
            if(getBF(current.left)>=0){
                current = rotateRight(current);
            } else{
                current.left = rotateLeft(current.left);
                current = rotateRight(current);
            }
        } else if(bf < -1){
            if(getBF(current.right)<=0){
                current = rotateLeft(current);
            } else {
                current.right = rotateRight(current.right);
                current = rotateLeft(current);
            }
        }

        return current;
    }
}


// class Node{
//     int data;
//     Node left, right;
//     int height;

//     Node(int data){
//         this.data = data;
//         this.height = 1;
//     }
// }

// public class AVLTree {
//     public Node root = null;

//     boolean isEmpty(){
//         return root == null;
//     }

//     int getHeight(Node node){
//         return (node!= null) ? node.height : 0;
//     }

//     int getBalance(Node node) {
//         if(node==null){
//             return 0;
//         }
//         return getHeight(node.left) - getHeight(node.right);
//     }

//     // gerak dari kiri ke kanan
//     Node rotateRight(Node b){
//         Node a = b.left;
//         Node temp = a.right;

//         a.right = b;
//         b.left = temp;

//         b.height = 1 + Math.max(getHeight(b.left), getHeight(b.right));
//         a.height = 1 + Math.max(getHeight(a.left), getHeight(a.right));

//         return a;
//     }

//     Node rotateLeft(Node b){
//         Node a = b.right;
//         Node temp = a.left;

//         b.right = temp;
//         a.left = b;

//         a.height = 1 + Math.max(getHeight(a.left), getHeight(a.right));
//         b.height = 1 + Math.max(getHeight(b.left), getHeight(b.right));

//         return a;
//     }

//     public void insert(int data){
//         root = insertRecursive(root, data);
//     }
//     private Node insertRecursive(Node current, int data){
//         if(current == null){
//             return new Node(data);
//         }
//         if(data < current.data){
//             current.left = insertRecursive(current.left, data);
//         } else{
//             current.right = insertRecursive(current.right, data);
//         }

//         current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));
//         int balance = getBalance(current);

//         // Left-heavy case
//         if(balance > 1){
//             // cek, data yg baru aja di-insert itu ada di left sub-tree atau di right sub-tree
//             if(data < current.left.data){
//                 return rotateRight(current);
//             } else {
//                 current.left = rotateLeft(current.left); // rotasiin dulu left subtree supaya jadi left-left case
//                 return rotateRight(current); // ini nanti menjadi kasus left-left case!! langsung saja rotate right
//             }
//         }
//         // Right heavy
//         if(balance < -1){
//             if(data >= current.right.data){
//                 return rotateLeft(current);
//             } else {
//                 current.right = rotateRight(current.right);
//                 return rotateLeft(current);
//             }
//         }

//         return current;
//     }

//     public Node getMinValueNode(Node node){
//         if(node.left == null){
//             return node;
//         }
//         return getMinValueNode(node.left);
//     }

//     public void delete (int data){
//         root = deleteRecursive(root, data);
//     }

//     private Node deleteRecursive(Node current, int data){
//         if(current == null) {
//             return null;
//         }

//         if(data < current.data){
//             current.left = deleteRecursive(current.left, data);
//         } else if(current.data < data){
//             current.right = deleteRecursive(current.right, data);
//         } else {
//             if(current.left == null){
//                 return current.right;
//             }
//             else if(current.right == null) {
//                 return current.left;
//             }

//             Node successor = getMinValueNode(current.right);
//             current.data = successor.data;
//             current.right = deleteRecursive(current.right, successor.data);
//         }
        
//         // SAFETY chek
//         if(current == null){
//             return current;
//         }

//         current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));
//         int balance = getBalance(current);

//         // left heavy
//         if(balance > 1){
//             if(getBalance(current.left) >= 0){
//                 return rotateRight(current);
//             } else{
//                 current.left = rotateLeft(current.left);
//                 return rotateRight(current);
//             }
//         }

//         if(balance < -1){
//             if(getBalance(current.right) <= 0) {
//                 return rotateLeft(current);
//             } else{
//                 current.right = rotateLeft(current.right);
//                 return rotateLeft(current);
//             }
//         }

//         return current;
//     }

//     public void displayInOrder(Node node){
//         if(node != null){
//             displayInOrder(node.left);
//             System.out.print(node.data + " ");
//             displayInOrder(node.right);
//         }
//     }
// }

