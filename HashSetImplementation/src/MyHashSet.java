
// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class MyHashSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;
    
    // Constructs an empty set.
    public MyHashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // Adds the given element to this set
    public void add(int value) {
    	// TO DO
    }
    
    // Removes all elements from the set.
    public void clear() {
    	// TO DO
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
    	// TO DO
    	return false;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
    	// TO DO
        return false;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
    	// TO DO
    }
    
    // Returns the number of elements in the queue.
    public int size() {
    	return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
    	// TO DO
    	return -1;
    }
    
    private double loadFactor() {
    	// TO DO
    	return 0.0;
    }
    
    // Resizes the hash table to twice its former size.
    private void rehash() {
    	// TO DO
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }
}
