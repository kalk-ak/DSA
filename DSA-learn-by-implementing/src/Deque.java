public interface Deque<E> {
    /** adds a new element at the front of the queue */
    void addFirst(E e);

    /** adds a new element at back of the queue */
    void addLast(E e);
    /** removes and returns the first element of the queue (null if empty).*/
    E removeFirst();
    /** removes and returns the last element of the queue (null if empty).*/
    E removeLast();
    /** @returns the first element of the queue, without removing it. (null if empty).*/
    E first();

    /** @returns the last element of the queue, without removing it. (null if empty) */
    E last();
    /** @returns the size of the list. */
    int size();

    /** checks if the list is empty */
    boolean isEmpty();

}
