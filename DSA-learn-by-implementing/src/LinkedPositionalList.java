import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {

    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();         // Position of the next element to report
        private Position<E> recent = null;            // Position of the most recently reported element

        /**
         * @return true if the iterator has a next object
         */
        public boolean hasNext() {
            return (cursor != null);
        }

        /**
         * @return the net position in the iterator
         * @throws NoSuchElementException
         */
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent);
        }
    }     // ------------------end of nested positionIterator class ----------------//

    //--------------------nested PositionIterable class -----------------------//
    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    } //---------------end of nested PositionIterable class --------------//

    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }


    // ------------------nested ElementIterator class ----------------//
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        }

        public void remove() {
            posIterator.remove();
        }
    } //-------------------end of nested class------------------------//

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    private static class Node<E> implements Position<E> {

        /**
         * @return the element stored at the position
         * @throws IllegalStateException if position no longer valid
         */
        @Override
        public E getElement() {
            return element;
        }

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public Node() {
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setElement(E e) {
            element = e;
        }

        private E element;
        private Node<E> prev;
        private Node<E> next;
    }

    private final Node<E> header;     // header sentinel
    private final Node<E> trailer;         // trailer sentinel
    private int size = 0;            // number of elements in the list


    /**
     * @return the first position in the list (null if list is empty)
     */
    @Override
    public Position<E> first() {
        if (isEmpty())
            return null;
        return header.getNext();
    }

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);          // creates the sentinel nodes
    }

    // private utilities

    /**
     * Validates the position and returns the node
     *
     * @param p = the position to be validated
     * @throws IllegalArgumentException
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) p;       // safe cast
        if (node.getNext() == null)       // convention for defunct node
            throw new IllegalArgumentException("position is no longer in the list");
        return node;
    }

    /**
     * @param node
     * @returns the given node as a position, unless it is a sentinel
     */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }

    private Position<E> addBetween(E e, Node<E> prec, Node<E> succ) {
        Node<E> newest = new Node<>(e, prec, succ);
        prec.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    /**
     * @returns the last position in list (null if list is empty)
     */
    @Override
    public Position<E> last() {
        return trailer.getPrev();
    }

    /**
     * @param p
     * @returns the position before position p (or null, if p is the first position).
     */
    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    /**
     * @param p
     * @throws IllegalArgumentException
     * @returns the position after position p (or null, if p is the last position).
     */
    @Override
    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    /**
     * @returns true if the list doesn't contain any positions.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @returns the size of the positional list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Inserts a new element e at the front of the list
     *
     * @param e
     * @returns the position of the new element.
     */
    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }


    /**
     * Inserts a new element at back of the list
     *
     * @param e
     * @returns the position of the new element
     */
    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Inserts a new element e in the list, just before position p
     *
     * @param p
     * @param e
     * @throws IllegalArgumentException
     * @returns the position of the new element
     */
    @Override
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    /**
     * Inserts a new element e in the list, just after position p
     *
     * @param p
     * @param e
     * @throws IllegalArgumentException
     * @returns the position of the new element
     */
    @Override
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /**
     * Replaces the element at position p with element e,
     *
     * @param p
     * @param e
     * @throws IllegalArgumentException
     * @returns the position of the new element
     */
    @Override
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    /**
     * Removes the element at position p (invalidating it)
     *
     * @param p
     * @throws IllegalArgumentException
     * @returns the removed element
     */
    @Override
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        E answer = node.getElement();
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }

    /**
     * Insertion-sort of a positional list of integers into ascending order
     */
    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if (value > marker.getElement())
                marker = pivot;           // pivot is already sorted
            else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() < value) {
                    Position<Integer> temp = walk;
                }
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }
}
