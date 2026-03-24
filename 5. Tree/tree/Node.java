package tree;

import java.util.ArrayList;


public class Node<T> {
    public T value;
    public ArrayList<Node<T>> children = new ArrayList<Node<T>>();

    public Node(T value){
        this.value = value;
    }
    public Node(T value, ArrayList<Node<T>> children){
        this.value = value;
        this.children = children;
    }
}
