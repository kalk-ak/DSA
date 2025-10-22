/*
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPositionalList<E> implements PositionalList<E> {

    private static class Pos<E> implements Position<E>{
        public Pos(E e) {
            element = e;
        }

        */
/**
         * @throws IllegalStateException if position no longer valid
         * @returns the element stored at the position
         *//*

        @Override
        public E getElement() {
            return element;
        }
        public void setElement(E e){
            element = e;
        }

        private E element;

    }
    private ArrayList<Pos<E>> positions = new ArrayList<>();

    // utilities


    */
/**
     * @returns the first position in the list (null if list is empty)
     *//*

    @Override
    public Position<E> first() {
        return positions.get(0);
    }

    */
/**
     * @returns the last position in list (null if list is empty)
     *//*

    @Override
    public Position<E> last() {
        return positions.get(positions.size());
    }

    */
/**
     * @param p
     * @returns the position before position p (or null, if p is the first position).
     *//*

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        if (!(positions.contains(p)))
            throw new IllegalArgumentException("Position is no longer valid");
        int index = positions.indexOf(p);
        if (index == 0)
            return null;
        return positions.get(index - 1);
    }

    */
/**
     * @param p
     * @throws IllegalArgumentException
     * @returns the position after position p (or null, if p is the last position).
     *//*

    @Override
    public Position<E> after(Position<E> p) {
        if (!(positions.contains(p)))
            throw new IllegalArgumentException("Position is no longer valid");
        int index = positions.indexOf(p);
        if (index == positions.size())
            return null;
        return positions.get(index + 1);
    }

    */
/**
     * @returns true if the list doesn't contain any positions.
     *//*

    @Override
    public boolean isEmpty() {
        return positions.size() == 0;
    }

    */
/**
     * @returns the size of the positional list
     *//*

    @Override
    public int size() {
        return positions.size();
    }

    */
/**
     * Inserts a new element e at the front of the list
     *
     * @param e
     * @returns the position of the new element.
     *//*

    @Override
    public Position<E> addFirst(E e) {
        positions.addFirst( new Pos<E>(e));
        return positions.getFirst();
    }

    */
/**
     * Inserts a new element at back of the list
     *
     * @param e
     * @returns the position of the new element
     *//*

    @Override
    public Position<E> addLast(E e) {
        positions.addLast( new Pos<E>(e));
        return positions.getLast();
    }

    */
/**
     * Inserts a new element e in the list, just before position p
     *
     * @param p
     * @param e
     * @throws IllegalArgumentException
     * @returns the position of the new element
     *//*

    @Override
    public Position<E> addBefore(Position<E> p, E e) {
        if (!(positions.contains(p)))
            throw new IllegalArgumentException("Position is no longer valid");
        int index = positions.indexOf(p);
        if (index == 0) {
            positions.addFirst(new Pos<E>(e));
        } else {
            positions.add(index, new Pos<E>(e));
        }
        return positions.get(0);

    }

    */
/**
     * Inserts a new element e in the list, just after position p
     *
     * @param p
     * @param e
     * @throws IllegalArgumentException
     * @returns the position of the new element
     *//*

    @Override
    public Position<E> addAfter(Position<E> p, E e) {
        if (!(positions.contains(p)))
            throw new IllegalArgumentException("Position is no longer valid");
        int index = positions.indexOf(p);
        if (index == positions.size()) {
            positions.addLast(new Pos<E>(e));
        } else {
            positions.add(index + 1, new Pos<E>(e));
        }
        return positions.get(0);
    }

    */
/**
     * Replaces the element at position p with element e,
     *
     * @param p
     * @param e
     * @throws IllegalArgumentException
     * @returns the position of the new element
     *//*

    @Override
    public E set(Position<E> p, E e) {
        if (!(positions.contains(p)))
            throw new IllegalArgumentException("Position no longer in the list");
        int index = positions.indexOf(p);
        E answer = positions.get(index).getElement();
        positions.get(index).setElement(e);
        return answer;

    }

    */
/**
     * Removes the element at position p (invalidating it)
     *
     * @param p
     * @throws IllegalArgumentException
     * @returns the removed element
     *//*

    @Override
    public E remove(Position<E> p) {
        if (!(positions.contains(p)))
            throw new IllegalArgumentException("Position no longer in the list");
         E answer = positions.get(positions.indexOf(p)).getElement();
         positions.remove(p);
         return answer;
    }
}
*/
