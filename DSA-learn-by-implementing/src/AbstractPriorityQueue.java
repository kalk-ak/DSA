import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    //------------------nested priority queue entry class....................

    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public PQEntry(K k, V v) {
            key = k;
            value = v;
        }

        // methods of the Entry interface
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K k) {
            key = k;
        }

        protected void setVale(V v) {
            value = v;
        }
    } //----------------end of nested class---------------------

    protected PQEntry<K, V> createEntry(K key, V value) {
        return new PQEntry<>(key, value);
    }

    // instance variable for an AbstractPriorityQueue
    /** The comparator of defining the ordering of Keys in the priority queue. */
    private Comparator<K> comp;

    /** Creates an empty priority queue using the given comparator to order keys */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }
    /** creates an empty priority queue based on the natural ordering of its keys */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    /**
     * compares two entries according to key */
     protected int compare(Entry<K, V> a, Entry<K, V> b) {
         return comp.compare(a.getKey(), b.getKey());
     }

    /** tests whether the priority queue is empty **/
    public boolean isEmpty() {return size() == 0; }






}
