import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    //------------------nested MapEntry class -----------------------//
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        public MapEntry(K k, V v) {
            key = k;
            value = v;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }

        protected void setKey(K k) { key = k; }
        protected V setValue(V v) {
            V old = value;
            value = v;
            return old;
        }
    } //------------------------ end of nested MapEntry class ----------------------------//

    /** tests if the map is empty */
    public boolean isEmpty() { return size() == 0; }

    // Support for public KeySet() method
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();
        public boolean hasNext() { return entries.hasNext(); }
        public K next() { return entries.next().getKey(); }
        public void remove() { entries.remove(); }
    }
    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet() { return new KeyIterable() ; }

    // Support for public values method
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() { return new ValueIterator(); }
    }

    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();
        public boolean hasNext() { return entries.hasNext(); }
        public V next() { return entries.next().getValue(); }
        public void remove() { entries.remove();}
    }
    public Iterable<V> values() { return new ValueIterable(); }
}

