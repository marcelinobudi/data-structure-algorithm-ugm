import java.util.Arrays;

public class Queue<T> {
    private Object[] arr;
    private int front = -1;
    private int rear = -1;
    private int length = 0;

    public Queue(int maxSize){
        arr = new Object[maxSize];
    }

    private void incrementFront() {
        this.front = (front + 1)%arr.length;
    }

    private void incrementRear() {
        this.rear = (rear + 1)%arr.length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public boolean isFull() {
        return length == arr.length;
    }

    public void enqueue(T element){
        if(isFull()) {
            return;
        }
        if(isEmpty()) {
            incrementFront();
        }
        incrementRear();
        arr[rear] = element;
        length++;
    }

    public T dequeue(){
        if(isEmpty()) {
            return null;
        }
        T itemReturn = (T) arr[front];
        incrementFront();
        length--;
        if(isEmpty()){
            front = -1;
            rear = -1;
        }
        return itemReturn;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }
        int temp = Integer.valueOf(front);
        System.out.print("[");
        int count = 0;
        while(count < length){
            System.out.print(arr[temp]);
            temp = (temp + 1)%arr.length;
            if(count < length-1) {
                System.out.print(", ");
            }
            count++;
        }
        // if(temp == rear){
        //     System.out.print(arr[temp]);
        // } else if(isFull()) {
        //     int count = 0;
        //     while(count < length){
        //         System.out.print(arr[temp]);
        //         temp = (temp + count)%arr.length;
        //         if(temp != rear) {
        //             System.out.print(", ");
        //         }
        //         count++;
        //     }
        // } else {
            
        // }
        System.out.println("]");
    }

    public int getLength() {
        return length;
    }

}
