public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * @param p
     * @return the position of the sibling of position p (or null if p has no sibling)
     */
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if(parent == null)
            return  null;
        else if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    /**
     * @param p the position whose number of children we're looking for
     * @return
     */
    @Override
     public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    /**
     * @param p the position whose children we are looking for
     * @return an iterable collection of the positions representing p's children.
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        ArrayList<Position<E>> arr = new ArrayList<>(2);
        if (left(p) != null)
            arr.add(left(p));
        if (right(p) != null)
            arr.add(right(p));
        return arr;
    }
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }
    /**
     * @return an iterable collection of positions of the tree reported in inorder
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!(isEmpty()))
            inorderSubtree(root(), snapshot);
        return snapshot;
    }
    public Iterable<Position<E>> positions() {
        return this.inorder();
    }







}
