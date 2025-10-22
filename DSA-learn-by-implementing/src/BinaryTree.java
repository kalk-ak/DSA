public interface BinaryTree<E> extends Tree<E> {
    /**
     * @return the position of the left child of position p (or null if p has no left child)
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * @return the position of the right child of position p (or null if p has no right child)
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * @return the position of the sibling of position p (or null if p has no sibling)
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;


}