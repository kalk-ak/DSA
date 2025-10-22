import java.util.Comparator;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** primary collection of priority queue entries */
    private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys */
    public SortedPriorityQueue() { super();}

    /** Creates an empty prioriy queue based on the given comparator */
    public SortedPriorityQueue(Comparator<K> comp) { super(comp);}


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
     * @return the entry created
     */
    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newest = createEntry(key, value);
        Position<Entry<K, V>> walk = list.last();

        // walk backward, looking for smaller key
        while (walk != null && compare(newest, walk.getElement()) < 0)
            walk = list.before(walk);

        if (walk == null)
            list.addFirst(newest);
        else
            list.addAfter(walk, newest);

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
        return list.first().getElement();
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

        return list.remove(list.first());
    }
}
