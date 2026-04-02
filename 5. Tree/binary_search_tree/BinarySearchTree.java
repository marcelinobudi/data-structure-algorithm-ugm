package binary_search_tree;

/*
Method yang wajib ada:
- public addNode() dan private insertNode()
- minValue()
- deleteNode()
- preOrder, postOrder, inOrder
- searchValue()
*/
public class BinarySearchTree {
    public Node root = null;
    public void addNode(int value){
        Node node = new Node(value);
        if(root == null) {
            root = node;
            return;
        }
        insertNode(root, node);
    }

    public void addNode(Node node){
        if(root == null) {
            root = node;
            return;
        }
        insertNode(root, node);
    }

    public void insertNode(Node parent, Node node){
        if(parent.value > node.value){
            if(parent.left == null){
                parent.left = node;
                return;
            }
            insertNode(parent.left, node);
            
    
        } else{
            if(parent.right == null){
                parent.right = node;
                return;
            }
            insertNode(parent.right, node);
        }
    
    }

    public int minValue(){
        return minValue(root);
    }

    private int minValue(Node node){
        if(node.left == null){
            return node.value;
        }
        return minValue(node.left);
    }

    public int maxValue(){
        return maxValue(root);
    }
    private int maxValue(Node node){
        if(node.right == null){
            return node.value;
        }
        return maxValue(node.right);
    }

    public void delete(int value){
        root = deleteResult(root, value);
    }

    private Node deleteResult(Node node, int value){
        if(node == null){
            return null;
        }

        if(value < node.value){
            node.left = deleteResult(node.left, value);
        } else if(value > node.value){
            node.right = deleteResult(node.right, value);
        } else {
            if(node.left == null){
                return node.right;
            } else if(node.right == null){
                return node.left;
            }
            // AMBIL NODE paling kecil di right subtree
            // letakan di NODE saat ini.
            node.value = minValue(node.right);
            node.right = deleteResult(node.right, node.value);

        }
        return node;
    }

    public static void preOrder(Node node){
        if(node != null){
            System.out.print(node.value + " ");
            preOrder( node.left);
            preOrder(node.right);
        }
    }

    public static void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    public boolean searchValue(int value){
        return searchValue(root, value);
    }

    public boolean searchValue(Node node, int value){
        if(node == null){
            return false;
        }
        if(node.value == value){
            return true;
        }
        else if(node.value > value){
            return searchValue(node.left, value);
        }
        else{
            return searchValue(node.right, value);
        }
        
    }
}
