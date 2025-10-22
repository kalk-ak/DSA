import javax.swing.plaf.PanelUI;
import java.util.Iterator;
import java.util.Queue;

public abstract class AbstractTree<E> implements Tree<E> {
    //--------------------nested element iterator class -----------------------//

    /**
     * This utility class adapts the iteration produced by positions() to return elements.
     */
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext() { return posIterator.hasNext(); }
        public E next() { return posIterator.next().getElement(); } // returns element
    }
    /** returns an iterator of the elements stored in the tree. */
    public Iterator<E> iterator() {return new ElementIterator(); }
    public Iterable<Position<E>> positions() {return preorder(); }
    public boolean isInternal (Position<E> p) { return numChildren(p) == 0; }
    public boolean isExternal (Position<E> p) { return numChildren(p) > 0; }
    public boolean isRoot (Position<E> p) { return p == root(); }
    public boolean isEmpty() { return size() == 0; }
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    private int heightBad() {
        int h = 0;
        for (Position<E> p : this.positions())
            if (isExternal(p))
                h = Math.max(h, depth((p)));
        return h;
    }

    /**
     * @return (int) the height of the subtree rooted at position p
     */
    public int height (Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }
    /**
     * utility - Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void preorderSubtree (Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    /**
     * @return an iterable collection of positions of the tree, reported in preorder.
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!(isEmpty()))
            preorderSubtree(root(), snapshot);
        return snapshot;
    }
    /**
     * utility - adds positions of the subtree rooted at position p to the given list
     * @param snapshot - the list positions are added to
     * @param p - the root to start the recursive adding
     */
    public void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!(isEmpty()))
            postorderSubtree(root(), snapshot);
        return snapshot;
    }
    /**
     * @return an iterable collection of positions of the tree in breadth-first order
     */
    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!(isEmpty())) {
            LinkedQueue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while (!(fringe.isEmpty())) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c : children(p))
                    fringe.enqueue(c);
            }
        }
        return snapshot;
    }


}
