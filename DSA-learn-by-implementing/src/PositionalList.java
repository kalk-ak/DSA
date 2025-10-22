public interface PositionalList<E>  extends Iterable<E>{
    /**
     * @returns the first position in the list (null if list is empty)
     */
    Position<E> first();

    /**
     * @returns the last position in list (null if list is empty)
     */
    Position<E> last();

    /**
     * @returns the position before position p (or null, if p is the first position).
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * @returns the position after position p (or null, if p is the last position).
     * @throws IllegalArgumentException
     */
    Position<E> after(Position<E> p);

    /**
     * @returns true if the list doesn't contain any positions.
     */
    boolean isEmpty();

    /**
     * @returns the size of the positional list
     */
    int size();

    /**
     * Inserts a new element e at the front of the list
     * @returns the position of the new element.
     */
    Position<E> addFirst(E e);

    /**
     * Inserts a new element at back of the list
     * @returns the position of the new element
     */
    Position<E> addLast(E e);

    /**
     * Inserts a new element e in the list, just before position p
     * @returns the position of the new element
     * @throws IllegalArgumentException
     */
    Position<E> addBefore(Position<E> p, E e);

    /**
     * Inserts a new element e in the list, just after position p
     * @returns the position of the new element
     * @throws IllegalArgumentException
     */
    Position<E> addAfter(Position<E> p, E e);

    /**
     * Replaces the element at position p with element e,
     * @returns the position of the new element
     * @throws IllegalArgumentException
     */
    E set(Position<E> p, E e);

    /**
     * Removes the element at position p (invalidating it)
     * @returns the removed element
     * @throws IllegalArgumentException
     */
    E remove(Position<E> p);

}
