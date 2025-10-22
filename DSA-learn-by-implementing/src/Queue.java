public interface Queue<E> {
    /** Adds element e at the back of the queue. */
    void enqueue(E e);

    /**
     *Removes and returns the first element from the queue
     * @returns the removed first element.
     */
    E dequeue();

    /**
     * @returns the first element of the queue without removing it.
     */
    E first();
    /**
     * @returns the number of elements in the queue.
     */
    int size();
    /**
     * Tests weather the queue is empty
     */
    boolean isEmpty();
}
