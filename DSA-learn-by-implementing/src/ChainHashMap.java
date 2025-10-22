public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    // a fixed capacity array of UnsortedTableMap that severs as buckets
    private UnsortedTableMap<K, V>[] table;
    public ChainHashMap() { super(); }
    public ChainHashMap(int cap) { super(cap); }
    public ChainHashMap(int cap, int prime) {super(cap, prime); }

    /** Creates an empty table having length equal to current capacity */
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    /** Returns value associated with key k in bucket with hash value h (null if empty) */
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            return null;
        else
            return bucket.get(k);
    }

    /**
     * Associates key with value in bucket with hash value h
     * @return old value (or null if emtpy)
     */
    protected V bucketPut(int h, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();
        int oldSize = bucket.size();
        V answer = bucket.put(key, value);
        n += (bucket.size() - oldSize);
        return answer;
    }

    /**
     * Removes entry key form bucket with hash value h (if any)
     * @return the removed value associated with key
     */
    public V bucketRemove(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(key);
        n -= (oldSize - bucket.size());
        return answer;
    }

    /**
     * Returns an iterable collection of all key-value entries of map
     */
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (int h=0; h < capacity; h++)
            if (table[h] != null)
                for (Entry<K, V> entry : table[h].entrySet())
                    buffer.add(entry);
        return buffer;
    }
}
