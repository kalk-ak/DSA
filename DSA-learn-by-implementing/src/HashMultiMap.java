import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Map;

public class HashMultiMap<K, V> {
    Map<K, List<V>> map = new HashMap<>();  // the primary map
    int total = 0;              // total number of entries in the multi map

    /** constructs an empty multi-map */
    public HashMultiMap() { }

    /** returns the total number of entries in the multimap */
    public int size() { return total; }

    /** returns a (possibly empty) iteration of all values associated with the key */
    Iterable<V> get(K key) {
        List<V> secondary = map.get(key);
        if (secondary != null)
            return secondary;
        return new ArrayList<>();        // returns an empty arraylist
    }

    /** Returns whether the multimap is empty */
    public boolean isEmpty() { return total == 0; }

    /** Adds a new entry association key with values */
    void put(K key, V value) {
        List<V> secondary = map.get(key);
        if (secondary == null) {
            secondary = new ArrayList<>();
            map.put(key, secondary);              // begins using the new list as secondary structure
        }
        secondary.add(value);
    }

    /** Removes the (key, Value) entry if exists */
    boolean remove(K key, V value) {
        boolean wasRemoved = false;
        List<V> secondary = map.get(key);
        if (secondary != null) {
            wasRemoved = secondary.remove(value);
            if (wasRemoved) {
                total--;
                if (secondary.isEmpty())
                    map.remove(key);            // remove secondary structure from primary map
            }
        }
        return wasRemoved;
    }

    /** Removes all entries with given key */
    Iterable<V> removeAll(K key) {
        List<V> secondary = map.get(key);
        if (secondary != null) {
            total -= secondary.size();
            map.remove(key);
        } else
            secondary = new ArrayList<>();
        return secondary;
    }

    /** Returns an iteration of all entries in the ultimap */
    Iterable<Map.Entry<K, V>> entries() {
        List<Map.Entry<K, V>> result = new ArrayList<>();
        for (Map.Entry<K, List<V>> secondary : map.entrySet()) {
            K key = secondary.getKey();
            for (V values : secondary.getValue())
                result.add(new AbstractMap.SimpleEntry<K, V>(key, values));
        }
        return result;
    }





















}
