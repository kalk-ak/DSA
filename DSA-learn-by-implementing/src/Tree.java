import java.util.Iterator;

public interface Tree<E> extends Iterable<E>{
    /**
     * @return the position of the root of the tree (or null if empty)
     */
    Position<E> root();

    /**
     * @param p the position whose parent is to be retrieved
     * @return the position of the parent of position p (or null if p is the root)
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p the position whose children we are looking for
     * @return an iterable collection containing the children of position p (if any)
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * returns the number of children of position p
     * @param p the position whose number of children we're looking for
     * @return (int - the number of children)
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p the position whose state we're checking
     * @return true if position p has at least one child
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p the position whose state we're checking
     * @return true if the position p does not have any children
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p the position we're checking
     * @return true if the position p is the root of the tree
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * @return (int) the number of positions (and hence elements) that are contained in the tree
     */
    int size();

    /**
     * @return (boolean) true if the tree does not contain any positions (and thus no elements)
     */
    boolean isEmpty();

    /**
     * @return (Iterator) an iterator for all the elements in the tree (so that the tree is itself is Iterable)
     */
    Iterator<E> iterator();

    /**
     * returns an iterable collection of all positions of the tree
     */
    Iterable<Position<E>> positions();




}

