public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V>{
    /**
     * removes an entry e from priority queue
     * @returns the removed entry
     */
   void remove(Entry<K, V> entry);

    /**
     * Replaces the key of existing entry e with k
     * returns the replaced key
     */
    void replaceKey(Entry<K, V> e, K key);

    /**
     * Replaces the value of existing entry e with v
     */
    void replaceValue(Entry<K, V> e, V value);
}
