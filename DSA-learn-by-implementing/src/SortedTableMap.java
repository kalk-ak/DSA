import java.util.Comparator;

/** An implementation of a map using a sorted table */
public class SortedTableMap<K, V> extends AbstractSortedMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    // constructors
    public SortedTableMap() { super(); }                          // orders keys naturally
    public SortedTableMap(Comparator<K> comp) { super(comp); }

    // ------------------ private utility methods --------------------------
    /** Returns the index of target key, if found, else the index where target could be inserted*/
    private int ceilingIndex(K target) {
        int low = 0, high = table.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comp = compare(target, table.get(mid).getKey());
            if (comp == 0)                     // target was found at mid
                return mid;
            else if (comp < 0)                 // target is smaller than table[mid]
                high = mid - 1;                // so continue searching left of mid
            else           // target is larger than table[mid]
                low = mid + 1; // so continue searching right of mid
        }
        return low;      // low = 1 + high in unsuccessful search
    }

    // -------------- private utility methods ---------------------
    /** returns the entry at index j, or else null if j is out of bounds */
    private Entry<K, V> safeEntry(int j) {
        if (j < 0 || j >= table.getSize())
            return null;
        else
            return table.get(j);
    }

    //----------------public methods ----------------------------
    /** returns the number of entries in the map */
    public int size() { return table.size(); }

    /** Returns the value associated with the key, or null if no such entry exists */
    public V get(K key) {
        int j = ceilingIndex(key);
        if (j == size() || compare(key, table.get(j).getKey() )!= 0)  // no match
            return null;
        return table.get(j).getValue();
    }

    /** Associates the given value with the given key, returning any overridden value */
    public V put(K key, V value) {
        int j = ceilingIndex(key);
        if (j < size() && compare(key, table.get(j).getKey()) == 0)
            return table.get(j).setValue(value);
        table.add(j, new MapEntry<K ,V> (key, value));
        return null;
    }
    /** Removes the entry with the specified key (if any) and returns its associated value */
    public V remove(K key) {
        int j = ceilingIndex(key);
        if (j < size() || compare(key, table.get(j).getKey()) != 0)
            return null;
        return table.remove(j).getValue();
    }

    /**
     * returns an iterable collection containing all the key-value entries in M.
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }


    /**
     * Returns the entry with the least key value (or null if empty)
     */
    @Override
    Entry<K, V> firstEntry() {
        return safeEntry(0);
    }

    /**
     * Returns the entry with the greatest key value( of null if empty)
     */
    @Override
    Entry<K, V> lastEntry() {
        return safeEntry(table.size() - 1);
    }

    /**
     * Returns the entry with the least key value greater than or equal to (k)
     * (or null if no such entry exists)
     *
     * @param k the key value
     */
    @Override
    Entry<K, V> ceilingEntry(K k) {
        return safeEntry(ceilingIndex(k));
    }

    /**
     * Returns the entry with the greatest key value less than or equal to k
     * (or null if no such entry exists)
     *
     * @param k
     */
    @Override
    Entry<K, V> floorEntry(K k) {
        int j = ceilingIndex(k);
        if (j == size() || !k.equals(table.get(j).getKey()))
            j--;          // look one earlier (unless we had found a perfect match)
        return safeEntry(j);
    }

    /**
     * Returns the entry with the greatest key value strictly less than k
     * (or null if no such entry exists)
     *
     * @param k
     */
    @Override
    Entry<K, V> lowerEntry(K k) {
        return safeEntry(ceilingIndex(k) - 1);
    }

    /**
     * Returns the entry with the least key value strictly greater than (k)
     * (or null if no such entry exists
     *
     * @param k
     */
    @Override
    Entry<K, V> higherEntry(K k) {
        int j = ceilingIndex(k);
        if (j < size() && k.equals(table.get(j).getKey()))
            j++;                   // go past exact match
        return safeEntry(j);
    }
    // ------------------- support for snapshot iterators -------------
    private Iterable<Entry<K, V>> snapshot(int startIndex, K stop) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        int j = startIndex;
        while (j < table.size() && (stop == null || compare(stop, table.get(j).getKey()) > 0))
            buffer.add(table.get(j++));
        return buffer;
    }


    /**
     * Returns an iteration of all entries with key greater than or equal to K1,
     * but strictly less than k2
     *
     * @param fromKey
     * @param toKey
     */
    @Override
    Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
        return snapshot(ceilingIndex(fromKey), toKey);
    }
}
