class OrderedArrayException extends RuntimeException{
    public OrderedArrayException(String message) {
        super(message);
    }
}

class OrderedArrayIndexOutOfBoundsException extends OrderedArrayException {
    public OrderedArrayIndexOutOfBoundsException(String message) {
        super(message);
    }
}

public class OrdArray {
    private Integer[] a;
    private int size = 0;

    public OrdArray(int maxSize){
        a = new Integer[maxSize];
    }

    // Add element using insertion sort.
    // HOW INSERTION WORKS
    // Elements in array have ordered position
    // So, just add new element in last index. Then, insert it to right position
    public void insert(int element){
        if(size >= this.maxLength()){
            throw new OrderedArrayIndexOutOfBoundsException("Array can only have " + maxLength() + " elements");
        }
        int i = size - 1;
        while(i >= 0 && a[i] > element){
            a[i + 1] = a[i];
            i--;
        }
        a[i+1] = element;
        size++;
    }   
    public int find(int element) {
        return find(element, 0, maxLength() - 1);
    }

    public int find(int element, int first, int last){
        if(first > last){
            return -1;
        }
        int middle = (last+first)/2;
        if(element == a[middle]){
            return middle;
        }
        else if(element > a[middle]){
            return find(element, middle+1, last);
        }
        return find(element, first, last-1);
        
    }

    public void delete(int element){
        int index = find(element);
        if(index == -1) return;
        for(int i = index; i < size-1; i++){
            a[i] = a[i+1];
        }
        a[size-1] = null;
        size--;
    }

    public int maxLength() {
        return a.length;
    }

    public Integer[] clone() {
        return a.clone();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            result.append(a[i]);
            if(i < size - 1) result.append(", ");
        }
        result.append(" ]");
        return result.toString();
    }
}
