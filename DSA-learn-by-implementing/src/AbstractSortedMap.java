import java.util.Comparator;

public abstract class AbstractSortedMap<K, V> extends AbstractMap<K, V> {
    // instance variables ------------------------------


    /** Returns the entry with the least key value (or null if empty) */
    abstract Entry<K, V> firstEntry();

    /** Returns the entry with the greatest key value( of null if empty) */
    abstract Entry<K, V> lastEntry();

    /** Returns the entry with the least key value greater than or equal to (k)
     * (or null if no such entry exists)
     */
    abstract Entry<K, V> ceilingEntry(K k);

    /** Returns the entry with the greatest key value less than or equal to k
     * (or null if no such entry exists)
     */
    abstract Entry<K, V> floorEntry(K k);

    /** Returns the entry with the greatest key value strictly less than k
     * (or null if no such entry exists)
     */
    abstract Entry<K, V> lowerEntry(K k);

    /** Returns the entry with the least key value strictly greater than (k)
     * (or null if no such entry exists
     */
    abstract Entry<K, V> higherEntry(K k);

    /** Returns an iteration of all entries with key greater than or equal to K1,
     * but strictly less than k2
     */
    abstract Iterable<Entry<K, V>> subMap(K k1, K k2);

    // constructors -----------------
    protected AbstractSortedMap(Comparator<K> comp) {
        comparator = comp;
    }
    protected AbstractSortedMap() { this(new DefaultComparator<>()); }


    protected int compare(K a, K b) {
        return comparator.compare(a, b);
    }

    protected Comparator<K> comparator;


}
