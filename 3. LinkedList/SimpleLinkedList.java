public class SimpleLinkedList<T> {
    Node<T> head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(T data){
        Node<T> newNode = new Node<T>(data);
        if(isEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void deleteFirst(){
        if(isEmpty()) return;
        head = head.next;
    }

    // For exercise only,
    // I want to do traversal for searching an object. It would returns a boolean value
    public boolean search(T data){
        if(isEmpty()) return false;
        Node<T> temp = head;
        while(temp != null){
            if(temp.data.equals(data)) return true;
            temp = temp.next;
        }
        return false;
    }

    public void display(){
        if(isEmpty()) {
            System.out.println("{}");
            return;
        }

        Node<T> temp = head;
        System.out.print("{ ");
        while (temp != null) {
            temp.display();
            temp = temp.next;
            if(temp != null) System.out.print(" -> ");
        }
        System.out.println(" }");
    }

}
