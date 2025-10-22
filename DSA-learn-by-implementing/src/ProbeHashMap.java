import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K,V>[] table;       // a fixed array of entries (all initially null)
    private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);


    // provide same construction as base class
    public ProbeHashMap() { super(); }
    public ProbeHashMap(int cap) { super(cap); }
    public ProbeHashMap(int cap, int prime) { super(cap, prime); }

    /**
     * Creates an empty table having length equal to current capacity
     */
    protected void createTable() {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    // private utility methods
    /**
     * Returns true if location is either empty or the "defunct" sentinel
     */
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    /**
     * Returns index with key k, or -(a + 1) such that K could be added at index a
     */
    private int findSlot(int h, K key) {
        int avail = -1;                               // no slot available (thus far)
        int j = h;                                    // index while scanning table
        do {
            if (isAvailable(j)) {                     // may be either empty or defunct
                if (avail == -1) avail = j;           // this is the first available slot!
                if (table[j] == null) break;          // if empty, search fails immediately
            } else if (table[j].getKey().equals(key))
                return j;                             // successful match
            j = (j+1) % capacity;                     // keep looking (cyclically)
        } while (j != h);                             // stop if we return to the start
        return -(avail + 1);                          // search has failed
    }

    /** Returns value associated with key in bucket with hash value h, or else null */
    protected V bucketGet(int h, K key) {
        int j = findSlot(h, key);
        if (j < 0)                          // no mach found
            return null;
        else
            return table[j].getValue();
    }

    /** Associates key k with value in bucket with hash value h
     * @returns old value (or null if there wasn't any)
     */
    protected V bucketPut(int h, K key, V value) {
        int j = findSlot(h, key);
        if (j >= 0)                                      // this key has an existing entry
            return table[j].setValue(value);
        table[-(j + 1)] = new MapEntry<>(key, value);   // convert to proper index
        n++;
        return null;
    }

    /** Removes entry having key k from bucket with hash value h (if any) */
    protected V bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if ( j < 0)                     // nothing to remove
            return null;

        V answer = table[j].getValue();
        table[j] = DEFUNCT;             // mark this slot as deactivated
        n--;
        return answer;                 // return removed value
    }

    /** returns an iterable collection of all key-value entries of the map */
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (int h = 0; h < capacity; h++) {
            if (!isAvailable(h))
                buffer.add(table[h]);
        }
        return buffer;
    }












}
