import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with an array (a longer exercise would be to
 * implement the List interface as is done in the class java.util.ArrayList: the
 * source of the ArrayList class is available from Sun. Check it out).
 */

public class MyArrayList<E> implements MyList<E> {

	// Use an array for the implementation
	private E[] items;

	// Default capacity of the array
	private static final int DEFAULT_CAPACITY = 10;

	// Number of elements in the array
	private int size;

	/**
	 * Constructs a MyArrayList with a specified capacity
	 */
	public MyArrayList(int initialCapacity) {
		this.items = (E[]) new Object[initialCapacity];
		this.size = 0;
	}

	/**
	 * Constructs a MyArrayList with a default capacity
	 */
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;

		return false;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	public boolean add(E o) {
		// If there is no room in the array items
		// Make room for the new element
		if (this.size >= this.items.length) {
			E[] newArray = (E[]) new Object[this.items.length * 2];
			for (int i = 0; i < this.items.length; i++) {
				newArray[i] = this.items[i];
			}
			this.items = newArray;
		}

		items[size++] = o;

		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() {
		this.size = 0;
		this.items = (E[]) new Object[this.items.length];
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) {
		// check for index out of bounds exception
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException("please enter a valid index");
		}
		return this.items[index];
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) {
		// If o is null (look for a null element in the array)
		if (o == null) {
			for (int i = 0; i < size(); i++) {
				if (o == items[i]) return i;
			}
		} else { // o is an object (use equals)
			for (int i = 0; i < size(); i++) {
				E currentObj = items[i];
				if (o.equals(currentObj))
					return i;
			}
		}
		// If we get here, o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) {
		if (indexOf(o) >= 0)
			return true;
		return false;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(int index) {
		if (index >= size())
			return false;
		for (int i = index + 1; i < items.length; i++) {
			items[i - 1] = items[i];
		}
		// do not need to set the last item to null because the size variable point below it,
		// essentially making it useless
		size--;
		// compact the array

		// let's gc do its work
		return true;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(Object o) {
		int objectIndex = indexOf(o);
		if (objectIndex == -1)
			return false;
		return remove(objectIndex);
	}

	/**
	 * Adds the specified object at the specified location
	 */
	public boolean add(int index, E o) {

		// precondition
		if (index < 0 || index > size()) return false;

		// I was going to add this to simplify things, but
		// I figured that for the purpose of this assignment
		// and proving that this method works properly anyways,
		// I just decided to leave it out.
//		if (index == size()) return add(o);

		// See inside comment for why this part is so long

		// If there is no room in the array items
		// Make room for the new element

		if (this.size >= this.items.length) {
			E[] newArray = (E[]) new Object[this.items.length * 2];
			// go over the lists with two iterators, one goes over the old one and one goes over the new one,
			// so we can add an offset between them. move until we reach the end of the NEW array (this is
			// important, if we go until the end of the old array it will not properly add an element to the end)
			for (int oldArrayIndex = 0, newArrayIndex = 0; newArrayIndex < this.items.length + 1; oldArrayIndex++, newArrayIndex++) {
				// if the index is for the added element, just insert the element there and shift
				// everything else up one, so we can do both the expansion and the addition in one
				// single operation, which seemed logical to me.
				if (oldArrayIndex == index) {
					// set object and THEN increment one extra
					newArray[newArrayIndex++] = o;
				} else {
					newArray[newArrayIndex] = this.items[oldArrayIndex];
				}
			}
			this.items = newArray;
			size++;
		} else {
			// iterate backwards from one greater than the current end of the list,
			// copying the previous item into the current index, and when we reach
			// the target index, copy the provided value into it.
			for (int i = size++; i > index; i--) {
				items[i] = items[i - 1];
			}
			items[index] = o;
		}
		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
	public boolean equals(Object o) {
		// JACOB IDK IF THIS WORKS OR NOTTT!!!!?!?!?!
		if (!(o instanceof MyArrayList)) {
			return false;
		}
		MyArrayList compared = (MyArrayList) o;
		if (compared.size() == this.size()) {
			// o is an ArrayList

			// if the number of elements is not the same, this and o are not the
			// same

			// Check the elements one by one
			for (int i = 0; i < this.size(); i++) {
				if (!compared.items[i].equals(this.items[i]))
					return false;
			}
			// At this point, the lists are equal
			return true;
		} else {
			return false;
		}
	}

	/**
	 * An inner class to define the iterator
	 */
	private class MyIterator implements Iterator<E> {
		private int index = 0;

		private MyArrayList<E> list;

		private int lastIndex = -1; // index of the object most recently visited

		// by next

		/**
		 * Create an iterator for a MyArrayList
		 */
		public MyIterator(MyArrayList<E> list) {
			this.list = list;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			return index < list.size();
		}

		/**
		 * Returns the current element in the list and move to the next element
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E element = list.get(index);
			lastIndex = index;
			index++;
			return element;
		}

		/**
		 * Removes the last object returned by next
		 */
		public void remove() {
			if (lastIndex < 0) {
				// I think this is correct
				throw new IllegalStateException();
			}
			list.remove(lastIndex);
			// subtract one from both index and lastIndex because when the item is removed,
			// the index of the last "next'd" element changes to the element "next'd" one before
			index--;
			lastIndex--;
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator(this);
	}
}
