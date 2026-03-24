public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> myQueue  = new Queue(5);
        myQueue.enqueue(1);
        myQueue.display();
        myQueue.enqueue(2);
        myQueue.display();

        myQueue.enqueue(3);
        myQueue.display();

        myQueue.enqueue(4);
        myQueue.display();
        myQueue.enqueue(5);
        myQueue.display();

        myQueue.enqueue(6);
        myQueue.display();

        
        while(!myQueue.isEmpty()){
            System.out.println("output: " + myQueue.dequeue().toString());
            myQueue.display();
        }
        myQueue.display();
    }
}
