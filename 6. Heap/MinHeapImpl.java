import min_heap.MinHeap;

public class MinHeapImpl {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Adding elements to reach [10, 15, 20, 17, 25]
        minHeap.insert(10);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(17);
        minHeap.insert(25);

        // Printing the internal array using the built-in Java utility
        // We use Arrays.copyOf because the capacity is 10, but we only have 5 items
        //System.out.println("Heap Content: " + Arrays.toString(Arrays.copyOf(minHeap.items, 5)));
        System.out.println("Heap Content: " + minHeap);
        
        // Verifying peek and poll
        System.out.println("Removed value (poll): " + minHeap.deleteTop()); // 10

        System.out.println("Heap Content: " + minHeap);
    }
}
