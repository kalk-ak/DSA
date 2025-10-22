import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /**
     * primary collection of priority queue entries
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Crates an empty priority queue based on the natural ordering of its keys
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue based on the given comparator to order the keys
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        int n = Math.min(keys.length, values.length);
        for (int i=0; i < n; i++)
            heap.add(createEntry(keys[i], values[i]));
        heapify();
    }
    public HeapPriorityQueue(ArrayList<Entry<K, V>> arr) {
        heapify();
    }
    protected void heapify() {
        int startIndex = parent(size()-1);
        for (int j=startIndex; j >= 0; j--) {
            downHeap(j);
        }
    }

    // protected utilities
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int leftChild(int j) {
        return (2 * j) + 1;
    }

    protected int rightChild(int j) {
        return (2 * j) + 2;
    }

    protected boolean hasLeft(int j) {
        return leftChild(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return rightChild(j) < heap.size();
    }

    /**
     * Exchange the entries at indices i and j of the array list
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap priority.
     */
    protected void upHeap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) break;
            swap(j, p);
            j = p;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap priority.
     */
    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIndex = leftChild(j);
            int smallestChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = rightChild(j);
                if (compare(heap.get(rightIndex), heap.get(leftIndex)) > 0)
                    smallestChildIndex = rightIndex;
            }
            if (compare(heap.get(j), heap.get(smallestChildIndex)) <= 0)
                break;
            swap(smallestChildIndex, j);
            j = smallestChildIndex;
        }
    }
    // public methods

    /**
     * @return int - the size of the priority queue
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * adds an object in the priority queue
     *
     * @param key   The priority of that object
     * @param value The value of that object
     * @return the newly created entry
     */
    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newest = createEntry(key, value);
        heap.add(newest);
        upHeap(heap.size() - 1);
        return newest;
    }


    /**
     * @return an object in the priority queue that associated with the highest priority
     * (null if empty)
     */
    @Override
    public Entry<K, V> min() {
        if (isEmpty())
            return null;
        else
            return heap.get(0);
    }

    /**
     * removes the highest priority entry (null if empty)
     *
     * @return the entry removed
     */
    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty())
            return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return answer;
    }
    public static <E> void pqSort(PositionalList<E> s, PriorityQueue<E,?> p) {
        int n = s.size();
        for (int j=0; j < n; j++) {
            E element = s.remove(s.first());
            p.insert(element, null);
        }
        for (int j=0; j < n; j++) {
            E element = p.removeMin().getKey();
            s.addLast(element);
        }
    }
}