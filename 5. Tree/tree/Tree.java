package tree;
public class Tree<T> {
    public Node<T> root;
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node<T> node){
        System.out.println(node.value);
        for(Node<T> child : node.children) {
            preOrder(child);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node<T> node){
        for(Node<T> child : node.children) {
            preOrder(child);
        }
        System.out.println(node.value);
    }
}
