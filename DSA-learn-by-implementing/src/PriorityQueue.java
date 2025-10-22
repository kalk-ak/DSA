public interface PriorityQueue<K, V> {
    /**
     * @return int - the size of the priority queue
     */
    int size();

    /**
     * @return boolean - True if the priority queue is empty. False other wise
     */
    boolean isEmpty();

    /**
     * adds an object in the priority queue
     * @param key The priority of that object
     * @param value The value of that object
     * @return
     */
    Entry<K, V> insert(K key, V value);

    /**
     * @return an object in the priority queue that associated with the highest priority
     * (null if empty)
     */
    Entry<K, V> min();

    /**
     * removes the highest priority entry (null if empty)
     * @return the entry removed
     */
    Entry<K, V> removeMin();




}
