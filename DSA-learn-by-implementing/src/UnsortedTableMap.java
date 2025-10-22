import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    /** Constructs an initially empty map */
    public UnsortedTableMap() { }

    // --------------- private utility -----------------------------

    /**
     * @param key the key we are looking for
     * @return the index of an entry with equal key, or -1 if none found
     */
    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++)
            if (table.get(j).getKey().equals(key))
                return j;
        return -1;
    } // ----------end of utility methods



    /**
     * @returns  the number of entries in M
     */
    @Override
    public int size() {
        return table.size();
    }

    /**
     * @param key
     * @return the value v associated with key K, if such an entry exists; otherwise returns null
     */
    @Override
    public V get(K key) {
        int i = findIndex(key);
        if (i != -1)
            return table.get(i).getValue();
        else
            return null;
    }

    /**
     * if Map does not have a key equal to k, it adds entry (key, value) to Map and returns null
     * else replaces with v, the existing value of the entry with key equal to k and returns the old value
     *
     * @param key
     * @param value
     * @return null or Value
     */
    @Override
    public V put(K key, V value) {
        int i = findIndex(key);
        if (i == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
           return table.get(i).setValue(value);
        }
    }

    /**
     * Removes the key from the Map
     * @param key
     * @return return the value removed (null if Map has no such entry)
     */
    @Override
    public V remove(K key) {
        int i = findIndex(key);
        if (i == -1)
            return null;
        V answer = table.get(i).getValue();
        int n = size();
        if ( i != n - 1)
            table.set(i, table.get(n - 1));
        table.remove(n - 1);
        return answer;

    }

    /**
     * returns an iterable collection containing all the key-value entries in M.
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    // -------- Utility class for entrySet() -------------------------
    private class EntryIterator implements Iterator<Entry<K, V>> {
        int index = 0;
        @Override
        public boolean hasNext() { return index < table.size(); }
        @Override
        public Entry<K, V> next() {
            if (hasNext())
                return table.get(index++);
            else
                throw new NoSuchElementException("No further entries");
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    }
    private class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() { return new EntryIterator(); }
    }



}
