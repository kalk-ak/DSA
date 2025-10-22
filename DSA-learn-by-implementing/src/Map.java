

public interface Map<K, V> {
    /**
     * @returns - int - the number of entries in M
     */
    int size();

    /**
     * @returns - boolean - a boolean indicating whether M is empty
     */
    boolean isEmpty();

    /**
     * @return the value v associated with key K, if such an entry exists; otherwise returns null
     */
    V get(K key);

    /**
     * if Map does not have a key equal to k, it adds entry (key, value) to Map and returns null
     * else replaces with v, the existing value of the entry with key equal to k and returns the old value
     * @param key
     * @param value
     * @return null or Value
     */
    V put(K key, V value);

    /**
     * Removes the key from the Map
     * @param key
     * @return return the value removed (null if Map has no such entry)
     */
    V remove(K key);

    /**
     * @return an iterable collection containing of all the keys stored in the Map
     */
    Iterable<K> keySet();

    /**
     * @return an iterable collection containing all the values stored in the Map
     */
    Iterable<V> values();

    /**
     * returns an iterable collection containing all the key-value entries in M.
     */
    Iterable<Entry<K, V>> entrySet();






}
