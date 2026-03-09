public class DoubleEndedLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(T data){
        Node<T> newNode = new Node<T>(data);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void deleteFirst(){
        if(isEmpty()) return;
        head = head.next;
    }

    // prefer using Doubly Linked List if we handle deleteLast more frequent
    public void deleteLast(){
        if(isEmpty()) return;
        Node<T> temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;   // !!!IMPORTANT: Don't forget to make temp.next null!
                            // If you forget, the tail never truly deleted
        tail = temp;
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
