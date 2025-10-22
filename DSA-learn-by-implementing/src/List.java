public interface List<T> extends Iterable<T> {
    /** @returns the number of elements in the list*/
    int size();

    /** @returns a boolean indicating whether the list is empty */
    boolean isEmpty();

    /**@returns (but does not remove) the element at index i */
    T get(int i) throws IndexOutOfBoundsException;

    /**
     * @replaces the element at index i with e
     * @returns the replaced element
     */
    T set(int i, T e) throws IndexOutOfBoundsException;

    /** @Inserts element e to be at index i, shifting all subsequent elements later. */
    void add(int i, T e) throws IndexOutOfBoundsException;

    /**
     * @inserts element e at the end of the list
     */
    void add(T e);

    boolean remove(T e);

}
