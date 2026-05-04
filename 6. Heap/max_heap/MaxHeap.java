package max_heap;

import java.util.ArrayList;
// Import the ArrayList class from Java's utility library.
// This will be used to store the heap elements dynamically.

public class MaxHeap {
	// Define a Heap class that contains methods to manipulate a max-heap.
    ArrayList<Integer> arr;
    public MaxHeap(){
        arr = new ArrayList<>();
    }

    int leftChild(int i) {
        return 2 * i + 1;
    }
    int rightChild(int i){
        return 2 * i + 2;
    }
	void heapify(int i) {
		int size = this.arr.size();       
		int largest = i;      
		int l = leftChild(i);          
		int r = rightChild(i);         

		if (l < size && this.arr.get(l) > this.arr.get(largest))
			largest = l;

		if (r < size && this.arr.get(r) > this.arr.get(largest))
			largest = r;

		if (largest != i) {
            // SWAP
			int temp = this.arr.get(largest); 
			this.arr.set(largest, this.arr.get(i));  
			this.arr.set(i, temp);    
            
            // REKURSIF ke index yg SEBELUMNYA DITUNJUK i (sekarang largest)!
			heapify(largest); 
		}
	}

	public void insert(int newNum) {
		int size = this.arr.size();
        this.arr.add(newNum); 
		if(size != 0) {      
			for (int i = size / 2 - 1; i >= 0; i = i/2-1) {
				heapify(i);
			}
		}
	}

	public void deleteNode(int num) {

		int size = this.arr.size();
		int i;
        // pencarian index dari node
		for (i = 0; i < size; i++) {
			if (num == this.arr.get(i))
				break;
		}

        // swap dengan node paling akhir
		int temp = this.arr.get(i);
		this.arr.set(i, this.arr.get(size - 1));
		this.arr.set(size - 1, temp);

        // hapus root node (yg telah ditukar)
		this.arr.remove(size - 1);

        // heapify
		for (int j = size / 2 - 1; j >= 0; j = j/2-1) {
			heapify(j);
		}
	}

	public void printArray() {
		for (Integer i : this.arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

    public void inOrderPrint(int i){
        if(i>=this.arr.size()) return;
        inOrderPrint(leftChild(i));
        System.out.print(this.arr.get(i) + " ");
        inOrderPrint(rightChild(i));
    }

    public void preOrderPrint(int i){
        if(i>=this.arr.size()) return;
        System.out.print(this.arr.get(i) + " ");
        inOrderPrint(leftChild(i));
        inOrderPrint(rightChild(i));
    }

	public void deleteTop() {
		int size = this.arr.size();
		if (size == 0) {
			System.out.println("Heap is empty, nothing to delete.");
			return;
		}

		int temp = this.arr.get(0);
		this.arr.set(0, this.arr.get(size - 1));
		this.arr.set(size - 1, temp);

		this.arr.remove(size - 1);

		heapify(0);
	}
}
