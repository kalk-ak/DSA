import java.util.Comparator;

public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V>
                                    implements AdaptablePriorityQueue<K, V>{
    /**
     * removes an entry e from priority queue
     */
    @Override
    public void remove(Entry<K, V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        int j = locator.getIndex();

        if ( j == heap.size() - 1)
            heap.remove(heap.size() - 1);

        else {
            swap(j, heap.size() - 1);
            heap.remove(size() - 1);
            bubble(j);
        }
    }

    /**
     * Replaces the key of existing entry e with k
     * returns the replaced key
     */
    @Override
    public void replaceKey(Entry<K, V> e, K key) throws IllegalArgumentException{
        AdaptablePQEntry<K, V> locator = validate(e);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    /**
     * Replaces the value of existing entry e with v

     */
    @Override
    public void replaceValue(Entry<K, V> e, V value) throws IllegalArgumentException{
        AdaptablePQEntry<K, V> locator = validate(e);
        locator.setVale(value);
    }
    //---------------- nested AdaptablePQEntry class ----------------
    /** Extension of the PQEntry to include location information. */
    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        protected int index;     //Heaps current index

        public AdaptablePQEntry(K key, V value, int j) {
            super(key, value);
            index = j;
        }

        public int getIndex() { return index; }
        public void setIndex(int i) { index = i; }
    } // ----------------end of nested class

    @Override
    protected PQEntry<K, V> createEntry(K key, V value) {
        return new AdaptablePQEntry<>(key, value, heap.size()); // new entry starts at the end of array
    }

    /** Creates an empty adaptable priority queue using natural ordering of keys */

    public HeapAdaptablePriorityQueue() { super();}
    /** Creates an empty adaptable priority queue using the provided comparator to order the keys */
    public HeapAdaptablePriorityQueue(Comparator<K> comp) { super(comp);}

    // ------------------- protected utilities ------------------------

    protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
        if (!(entry instanceof HeapAdaptablePriorityQueue.AdaptablePQEntry<K,V>))
            throw new IllegalArgumentException("Invalid entry");

        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;
        int j = locator.getIndex();
        if (j >= heap.size() || heap.get(j) != locator)
            throw new IllegalArgumentException("Invalid input");
        return locator;
    }
    @Override
    /** Exchanges the entries at indices i and j of the array list */
    protected void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j);
    }

    /**
     * restores the heap property by moving the entry at index j upward
     */
    protected void bubble(int j) {
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
            upHeap(j);
        else
            downHeap(j);
    }

    // ------------------ public methods ---------
    /** removes the given entry from the priority queue */



















}
