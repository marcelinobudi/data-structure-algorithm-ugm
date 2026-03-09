public class Node<T>{
    public T data;
    public Node<T> next = null;

    public Node(T data){
        this.data = data;
    }

    public void display(){
        System.out.print("{"+ data.toString() + "}");
    }
}