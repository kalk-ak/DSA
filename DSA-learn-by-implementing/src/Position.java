public interface Position<T> {
    /**
     *  @returns the element stored at the position
     * @throws IllegalStateException if position no longer valid
     */

    T getElement();
}
