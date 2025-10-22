import java.sql.PseudoColumnUsage;
import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{
    //-----------nested node class ----------------//
    /** Nested static class for a binary tree node */
    protected static class Node<E> implements Position<E> {
        private E element;           // an element stored at this node
        private Node<E> parent;     // a reference to the parent node (if any)
        private Node<E> left;        // a reference to the left child (if any)
        private Node<E> right;        // a reference to the right child (if any)

        /**
         * constructs a node with the given element and neighbors
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        // getters
        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }

        // setters
        public void setElement(E e) {element = e; }
        public void setParent(Node<E> parentNode) { parent = parentNode; }
        public void setLeft(Node<E> newLeft) { left = newLeft; }
        public void setRight(Node<E> newRight) { right = newRight; }
    } //----------------------end of nested class----------------------//

    // protected utility----------------------------------------
    /** Factory function to create a new node storing element e */
    protected Node<E> createNode(E e, Node<E> parent, Node left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // LinkedBinaryTree instance variable
    protected Node<E> root = null;
    private int size = 0;

    // constructor
    public LinkedBinaryTree() {}


    /**
     * Validates the position and returns it as a node
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>) p;   // safe cast
        if (node.getParent() == node)  // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    //-------------------end of utility methods------------------------------//
    /**
     * creates a root for an empty tree storing e as the element
     * @param e
     * @return the position of that root
     * @throws IllegalArgumentException if this.tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException{
        if (!(isEmpty())) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * creates a left child of position p, storing element e
     * @param p the parent position
     * @param e the element to be stored
     * @return the position of the new node
     * @throws IllegalStateException if p already has a left child
     * @throws IllegalArgumentException if p is not a valid position
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalStateException, IllegalArgumentException{
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("P already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * creates a right child of Position p, storing element e
     * @param p the parent position
     * @param e the element to be stored
     * @return the position of the new node
     * @throws IllegalStateException if p already has a right child
     * @throws IllegalArgumentException if p is not a valid position
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalStateException, IllegalArgumentException{
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("P already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * replaces the element stored at position p with element e
     * @return the previously stored element
     * @throws IllegalArgumentException if p is not a valid position
     */
    public E set(Position<E> p,E e) {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Attaches the internal structure of trees TL and TR as the respective left
     * and right subtrees of leaf position p and resets tL and TR to empty trees
     * @throws IllegalArgumentException if P is not a leaf
     * @param TL left tree
     * @param TR right tree
     * @param p the prospective parent of Tree Left and Tree Right
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> TL, LinkedBinaryTree<E> TR) {
        Node<E> parent = validate(p);
        if (isInternal(p))
            throw new IllegalArgumentException("P must be a leaf");
        if (!(TL.isEmpty())) {
            TL.root.setParent(parent);
            parent.setLeft(TL.root);
            TL.root = null;
            TL.size = 0;
        }
        if (!(TR.isEmpty())) {
            TR.root.setParent(parent);
            parent.setRight(TR.root);
            TR.size = 0;
            TR.root = null;
        }
    }

    /**
     * removes the node at position p, replacing it with its child (if any),
     * @return the element that had been stored at p
     * @throws IllegalArgumentException if p has two children
     */
    public E remove(Position<E> p) {
        Node<E> temp = validate(p);
        if (numChildren(p) >= 2)
            throw new IllegalArgumentException("Position must have at most 1 child");
        Node<E> child = (temp.getLeft() != null ? temp.getLeft() : temp.getRight());
        if (child != null)
            child.setLeft(temp.getParent());
        if (temp == root)
            root = child;
        else {
            Node<E> parent = temp.getParent();
            if (temp == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E answer = temp.getElement();
        temp.setElement(null);
        temp.setRight(null);
        temp.setLeft(null);
        temp.setParent(temp);
        return answer;

    }


    // accessor methods
    /**
     * @param p
     * @return the position of the left child of position p (or null if p has no left child)
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * @param p
     * @return the position of the right child of position p (or null if p has no right child)
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    /**
     * @return the position of the root of the tree (or null if empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * @param p the position whose parent is to be retrieved
     * @return the position of the parent of position p (or null if p is the root)
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * @return (int) the number of positions (and hence elements) that are contained in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return (Iterator) an iterator for all the elements in the tree (so that the tree is itself is Iterable)
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * returns an iterable collection of all positions of the tree
     */
    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }
    public static <E> void parenthesize(Tree<E> T, Position<E> p) {
        System.out.println(p.getElement());
        if (T.isInternal(p)) {
            String preface = " (";
            for (Position<E> c : T.children(p)) {
                System.out.println(preface);
                preface = ", ";
                parenthesize(T, c);
            }
            System.out.println(")");
        }
    }
    /**
     * @return total disk space for subtree of T rooted at p
     */
    public static float diskSpace(Tree<Float> T, Position<Float> p) {
        float subtotal = p.getElement();
        for (Position<Float> c : T.children(p))
            subtotal += diskSpace(T, c);
        return subtotal;
    }
}

