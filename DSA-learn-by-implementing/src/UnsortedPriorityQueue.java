import java.util.Comparator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** primary collection of priority queue entries */
    private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    /** Creates an empty priority queue using the natural Comparator */
    public UnsortedPriorityQueue() { super(); }

    /** Creates an empty priority queue using the given Comparator */
    public UnsortedPriorityQueue(Comparator<K> comp) { super(comp); }

    /** Returns the position of an entry having minimal key (null if empty) */
    private Position<Entry<K, V>> findMin() { // not called on an empty list

        Position<Entry<K, V>> small = list.first();
        if (!(list instanceof Iterable<?>))
            throw new UnsupportedOperationException("List is not iterable");

        for (Position<Entry<K, V>> walk : list.positions())
            if (compare(walk.getElement(), small.getElement()) < 0)
                small = walk;

        return small;
    }




    /**
     * @return int - the size of the priority queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * adds an object in the priority queue
     *
     * @param key   The priority of that object
     * @param value The value of that object
     * @return return the entry created
     */
    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newest = createEntry(key, value);
        list.addLast(newest);
        return newest;
    }

    /**
     * @return an object in the priority queue that associated with the highest priority
     * (null if empty)
     */
    @Override
    public Entry<K, V> min() {
        if (list.isEmpty())
            return null;
        return findMin().getElement();
    }

    /**
     * removes the highest priority entry (null if empty)
     *
     * @return the entry removed
     */
    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty())
            return null;

        return list.remove(findMin());

    }

}
