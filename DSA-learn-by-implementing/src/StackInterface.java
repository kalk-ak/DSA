public interface StackInterface<E> {
    /**
     * @returns number of elements in the stack.
     */
    int size();
    /**
     * Tests weather the stack is empty.
     * @returns true if the stack is empty, false otherwise.
     */
    boolean isEmpty();
    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    E top();
    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    E pop();

    void push(E e);


}
