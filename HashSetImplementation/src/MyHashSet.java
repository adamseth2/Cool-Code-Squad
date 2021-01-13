
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
    // Jacob
    public void add(int value) {
        int hash = hashFunction(value);
        if (contains(value)) return;
        if (elementData[hash] == null) {
            elementData[hash] = new HashEntry(value);
        } else {
            // currentEntry = elementData[hash];
            // while (currentEntry.next != null) currentEntry = currentEntry.next;
            // currentEntry.next = new HashEntry(value);
            elementData[hash] = new HashEntry(value, elementData[hash]);
        }
        size++;
        if (loadFactor() > MAX_LOAD_FACTOR) rehash();
    }
    
    // Removes all elements from the set.
    //Make it so the capacity is the same after clearing
    //Adam
    public void clear() {
        elementData = new HashEntry[elementData.length];
    }
    
    // Returns true if the given value is found in this set.
    //Justin
    public boolean contains(int value) {
        HashEntry currentEntry = elementData[hashFunction(value)];
        //first check if the hash key has any values
        while(currentEntry != null){
            if(currentEntry.data == value){
                return true;
            }
            //loop through a linked list if there are multiple values in one hash key
            currentEntry = currentEntry.next;
        }
        return false;
    }
    
    // Returns true if there are no elements in this queue.
    // Justin
    public boolean isEmpty() {
        //if add function has never been called, the hashset is empty and size will still be 0
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    // Justin
    public void remove(int value) {
    	int hashIndex = hashFunction(value);
        HashEntry currentEntry = elementData[hashIndex];
        HashEntry previousEntry = null;
        while(currentEntry != null)
        {
            if(currentEntry.data == value && previousEntry == null)
            {
                elementData[hashIndex] = currentEntry.next;
                size--;
                break;
            } else if(currentEntry.data == value)
            {
                previousEntry.next = currentEntry.next;
                elementData[hashIndex] = previousEntry;
                size--;
                break;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.next;
        }
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
    	return Math.abs(value % elementData.length);
    }
    //Adam
    private double loadFactor() {
    	return (double) size/ elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    private void rehash() {
    	HashEntry[] oldElementData = this.elementData;
    	elementData = new HashEntry[oldElementData.length];
    	for (HashEntry element : elementData) {
    	    add(element.data);
      }
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
