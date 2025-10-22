import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>, Iterable<E>{
    // instance variables
    public static final int CAPACITY = 16;     // default array capacity
    private E[] data;                        // generic array used for storage
    private int size = 0;                    // current number of elements

    /**
     * A (nonstatic) inner class.
     * reference to the containing list, allowing it to access the list's members.
     */
    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;
        /**
         * @return true if there are further objects, false otherwise
         */
        public boolean hasNext() {
            return j < size;
        }
        /**
         * @return the next object in the iterator
         * @throws java.util.NoSuchElementException if there are no further elements
         */
        public E next() throws NoSuchElementException {
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }
        /**
         * @remove the elelment returned by most recent call to next.
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove was already called since recent next
         */
        public void remove() throws IllegalStateException {
            if (!removable) throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }

    }

    // constructors
    public ArrayList() {
        this(CAPACITY);
    }   // constructs list with default capacity

    public ArrayList(int capacity) {         // constructs list with given capacity
        data = (E[]) new Object[capacity];   // safe cast; compiler may give warning
    }

    // protected utility method

    /**
     * Checks whether the given index is in the range [0, n-1].
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
    protected void resize() {
        E[] arr = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++)
            arr[i] = data[i];
        data = arr;
    }

    // public methods

    /**
     * Returns the number of elements in the array list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the array list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns (but does not remove) the element at index i.
     */
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Replaces the element at index i with e, and returns the replaced element.
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserts element e to be at index i, shifting all subsequent elements later.
     */
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length)              // not enough capacity
            this.resize();
        for (int k = size - 1; k >= i; k--)       // start by shifting rightmost
            data[k + 1] = data[k];
        data[i] = e;                          // ready to place the new element
        size++;
    }

    /**
     * @param e
     * @inserts element e at the end of the list
     */
    @Override
    public void add(E e) {
        if (size == data.length)
            this.resize();
        data[size++] = e;
    }

    @Override
    public boolean remove(E e) {
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e))      // if element is found in data
                index = i;
            break;
        }
        if (index == -1)    // element not found, index didn't change
            return false;
        else {
            remove(index);
            return true;
        }
    }


    /**
     * Removes/returns the element at index i, shifting subsequent elements earlier.
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++)        // shift elements to fill hole
            data[k] = data[k + 1];
        data[size - 1] = null;                  // help garbage collection
        size--;
        return temp;
    }
    /**
     * @return an iterator of the elements stored in the list
     */
    public Iterator<E> iterator() {
        if (this == null)
            return null;
        return new ArrayIterator();
    }
}