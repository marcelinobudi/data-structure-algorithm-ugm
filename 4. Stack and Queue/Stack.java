import java.util.Arrays;

public class Stack<T> {
    private T[] arr;
    private int top = -1;
    public Stack(int max){
        arr = new T[max];
    }
    public bool isEmpty(){
        return top == -1;
    }

    public bool isFull(){
        return length() >= arr.length;
    }

    public int length() {
        return top+1;
    }

    public void push(T element){
        if(isFull()) {
            throw IndexOutOfBoundsException();
            return;
        }
        top++;
        arr[top] = element;
    }
    public void pop(){
        if(isEmpty()){
            return;
        }
        top--;
    }
    public T getTop() {
        if(isEmpty()){
            return null;
        }
        return arr[top];
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
