class Node{
    public int data;
    public Node next = null;
    public Node prev = null;

    public Node(int data){
        this.data = data;
    }

    public void display(){
        System.out.print("{"+ data + "}");
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    // ASUMSIKAN ini data terurut ascending (manual input)
    public void insertFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void removeDuplicate(){
        if(isEmpty()){
            return;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == current.data){
                Node temp = current.next;
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                }
                else {
                    temp.prev.next = null;
                }
            
            } else{
                // LAKUKAN HANYA ketika TIDAK MENGHAPUS
                current = current.next;
            }
            
            
        }
    }

    

    public void display(){
        if(isEmpty()) {
            System.out.println("{}");
            return;
        }

        Node temp = head;
        System.out.print("{ ");
        while (temp != null) {
            temp.display();
            temp = temp.next;
            if(temp != null) System.out.print(" -> ");
        }
        System.out.println(" }");
    }
}

public class LinkedListProblem {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertFirst(5);
        ll.insertFirst(5);
        ll.insertFirst(4);
        ll.insertFirst(3);
        ll.insertFirst(3);
        ll.insertFirst(2);
        ll.insertFirst(1);
        ll.display();
        ll.removeDuplicate();
        ll.display();
    }
}
