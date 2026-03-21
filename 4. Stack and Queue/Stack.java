import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;

public class Stack<T> {
    private Object[] arr;
    private int top = -1;
    public Stack(int max){
        arr = new Object[max];
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return length() >= arr.length;
    }

    public int length() {
        return top+1;
    }

    public void push(T element){
        if(isFull()) {
            throw new IndexOutOfBoundsException();
        }
        top++;
        arr[top] = element;
    }
    public T pop(){
        if(isEmpty()){
            return null;
        }
        return (T) arr[top--];
    }
    public T getTop() {
        if(isEmpty()){
            return null;
        }
        return (T) arr[top];
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
