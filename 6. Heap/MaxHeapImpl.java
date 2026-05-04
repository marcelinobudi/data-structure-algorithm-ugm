import java.util.ArrayList;

import max_heap.MaxHeap;

public class MaxHeapImpl {
    public static void main(String[] args) {

		MaxHeap h = new MaxHeap();       // Create a Heap object.

		// Insert elements into the heap.
		h.insert(3);
		h.insert(4);
		// h.insert(11);
		h.insert(9);
		h.insert(5);
		// h.insert(7);
		// h.insert(1);
		h.insert(2);

		System.out.println("Max-Heap array: ");
		h.printArray(); // Print the heap after insertions.

		// Delete the node with value 4.
		h.deleteNode(4);
		System.out.println("After deleting an element: ");
		h.printArray(); // Print the heap after deletion.

		// Delete the top element (max).
		h.deleteTop();
		System.out.println("After deleting top element: ");
		h.printArray();
		
		// Delete the top element (max).
		h.deleteTop();
		System.out.println("After deleting top element: ");
		h.printArray();
    }
}
