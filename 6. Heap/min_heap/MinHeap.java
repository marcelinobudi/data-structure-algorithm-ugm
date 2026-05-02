package min_heap;

import java.util.Arrays;

public class MinHeap {
    public int size = 0;
    private int capacity = 10;
    private int[] arr;

    public MinHeap(){
        arr = new int[capacity];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size==capacity;
    }

    private int parent(int index){
        return (int)0.5*(index-1);
    }

    private void swap(int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private int leftChild(int index){
        return 2*index +1;
    }

    private int rightChild(int index){
        return 2*index +2;
    }

    private boolean isLeftChildNotExist(int index){
        return leftChild(index) >= size;
    }

    private boolean isRightChildNotExist(int index){
        return rightChild(index) >= size;
    }


    private void updateCapacity(){
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);

    }

    

    private void heapifyUp(int index){
        if(index==0){
            return;
        }
        int parent = arr[parent(index)];
        int node = arr[index];
        if(parent > node){
            swap(index, parent(index)); // SWAP DILAKUKAN
            heapifyUp(parent(index));
        } 
    }

    private void heapifyDown(int index){
        int leftIdx = leftChild(index);
        int rightIdx = rightChild(index);
        if(isLeftChildNotExist(index)){
            return;
        }

        int leftChild = arr[leftIdx];
        int node = arr[index];
        int minimum = leftChild; // Asumsi sementara
        int minimumIdx = leftIdx;
        if(!isRightChildNotExist(index) && arr[rightIdx] < leftChild){
            minimum = arr[rightIdx];
            minimumIdx = rightIdx;
        }

        if(node > minimum){
            swap(index, minimumIdx);
            heapifyDown(minimumIdx);
        }
    }

    public void insert(int data){
        if(isFull()){
            updateCapacity();
        }
        arr[size++] = data;
        heapifyUp(size-1);
    }

    public int deleteTop(){
        if(isEmpty()) throw new IllegalStateException();
        int returned = arr[0];
        arr[0] = arr[--size];
        heapifyDown(0);
        return returned;
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
