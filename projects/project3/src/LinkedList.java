public class LinkedList<T extends Comparable<T>> implements List<T> {
    public LinkedList(){
        head = new Node<>(null, null);

    }


    Node<T> head;
    int size = 0;
    boolean isSorted = true;

    /**
     * Add an element to end of the list. If element is null,
     * it will NOT add it and return false.  Otherwise, it
     * will add it and return true. Updates isSorted to false if
     * the element added breaks sorted order.
     *
     * @param element element to be added to the list.
     * @return if the addition was successful.
     */
    @Override
    public boolean add(T element) {
        Node<T> last = head;
        while(last.getNext() != null)
            last = last.getNext();
        Node<T> newest = new Node<>(element);
        last.setNext(newest);
        size++;
        if (last.getData().compareTo(newest.getData()) == 1)
            isSorted = false;

        return true;
    }

    /**
     * Add an element at specific index. This method should
     * also shift the element currently at that position (if
     * any) and any subsequent elements to the right (adds
     * one to their indices). If element is null, or if index
     * index is out-of-bounds (index < 0 or index >= size_of_list),
     * it will NOT add it and return false. Otherwise it will
     * add it and return true. See size() for the definition
     * of size of list. Also updates isSorted variable to false if the
     * element added breaks the current sorted order.
     *
     * @param index   index at which to add the element.
     * @param element element to be added to the list.
     * @return if the addition was successful.
     */
    @Override
    public boolean add(int index, T element) {
        if (index >= size || index < 0)
            return false;
        Node<T> current = head;
        for (int i=0; i < index; i++)
            current = current.getNext();
        Node<T> newest = new Node(element, current.getNext());
        current.setNext(newest);
        size++;
        if(current.getData().compareTo(newest.getData()) == 1)
            isSorted = false;
        else if(newest.getNext() != null && newest.getData().compareTo(newest.getNext().getData()) == 1)
            isSorted = false;
        return true;

    }

    /**
     * Remove all elements from the list and updates isSorted accordingly.
     */
    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }

    /**
     * Return the element at given index. If index is
     * out-of-bounds, it will return null.
     *
     * @param index index to obtain from the list.
     * @return the element at the given index.
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        Node<T> current = head;
        for (int i=0; i <= index; i++)
            current = current.getNext();
        return current.getData();
    }

    /**
     * Return the first index of element in the list. If element
     * is null or not found in the list, return -1. If isSorted is
     * true, uses the ordering of the list to increase the efficiency
     * of the search.
     *
     * @param element element to be found in the list.
     * @return first index of the element in the list.
     */
    @Override
    public int indexOf(T element) {
        if (element == null)
            return -1;
        Node<T> current;
        if (isSorted){
            return 0;
        } else{
            current = head;
            for(int i=0; i < size; i++){
                current = current.getNext();
                if(current.getData().equals(element))
                    return i;
            }
            return -1;

        }
    }

    /**
     * Return true if the list is empty and false otherwise.
     *
     * @return if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * size() return the number of elements in the list. Be careful
     * not to confuse this for the length of a list like for an ArrayList.
     * For example, if 4 elements are added to a list, size will return
     * 4, while the last index in the list will be 3. Another example
     * is that an ArrayList like [5, 2, 3, null, null] would have a size
     * of 3 for an ArrayList.
     * ArrayList and LinkedList hint: create a class variable in both ArrayList
     * and LinkedList to keep track of the sizes of the respective lists.
     *
     * @return size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sort the elements of the list in ascending order using bubble sort.
     * If isSorted is true, do NOT re-sort.
     * Hint: Since T extends Comparable, you will find it useful
     * to use the public int compareTo(T other) method.
     * Updates isSorted accordingly.
     */
    @Override
    public void sort() {
        if(!isSorted){
            Node<T> current = head;
            Node<T> temp;
            for(int i=0; i < size - 1; i++){
                for(int j=0; j < size - i - 1; j++){
                    if(current.getNext().getData().compareTo(current.getNext().getNext().getData()) == 1){
                        temp = current.getNext();
                        current.setNext(current.getNext().getNext());
                        current.getNext().setNext(temp);
                        current = current.getNext();
                    }
                }
            }
            isSorted = true;
        }
    }

    /**
     * Remove whatever is at index 'index' in the list and return
     * it. If index is out-of-bounds, return null. For the ArrayList,
     * elements to the right of index should be shifted over to maintain
     * contiguous storage. Must check to see if the list is sorted after removal
     * of the element at the given index and updates isSorted accordingly.
     *
     * @param index position to remove from the list.
     * @return the removed element.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            return null;
        Node<T> current = head;
        for(int i=0; i < index; i++)
            current = current.getNext();
        Node<T> removed = current.getNext();
        current.setNext(current.getNext().getNext());
        removed.setNext(null);
        size--;
        return removed.getData();
    }

    /**
     * Remove all duplicate elements from the list.
     * The removal must be done in a stable manner,
     * or in other words the first occurrence of an element must keep its relative order
     * to the first occurrences of other elements.
     * Example A,B,A,C,B,A,D -> A,B,C,D
     */
    @Override
    public void removeDuplicates() {
        Node<T> current = head;
        Node<T> duplicates;
        for (int i = 0; i < size; i++) {
            current = current.getNext();
            for (int j = 0; j < size - 1; j++) {
                duplicates = current.getNext();
                if (current.getData() == duplicates.getData()) {
                    remove(this.indexOf(duplicates.getData()));
                    size--;
                }
            }
        }
    }

    /**
     * Reverses the list IN PLACE. Any use of intermediate data structures will yield
     * your solution invalid.
     */
    @Override
    public void reverse() {

        Node<T> next = head;
        while (next.getNext().getNext() != null)  // next is assigned to the second last Node;
            next = next.getNext();
        Node<T> newHead = next.getNext();    // crates a new head for the reversed list.
        next.setNext(null);    // useful for next looping


        Node<T> newLast = newHead;   // the last element in the reversed list;
        while (head.getNext().getNext() != null) {
            next = head.getNext();    // next is assigned to the first node in the linked list.
            while (next.getNext() != null)
                next = next.getNext();   // next is assigned the last element in the linked list.
            newLast.setNext(next);
            next.setNext(null);
            newLast = next;          // next becomes the last node in the reversed list.

        }
    }



    /**
     * The current list should be updated to contain all elements that are in
     * the current list or the other list, but NOT in both of the lists. As an
     * example, if list1 contains (A,B,C) and list2 contains (B,C,D), then
     * list1.exclusiveOr(list2) should contain (A,D).
     * <p>
     * If otherList is null, do not make any modifications.
     * <p>
     * The final result should be sorted and all duplicates should be removed.
     * Consider calling sort() and removeDuplicates() on both of the lists
     * before computing the exclusive or.
     * Note, you will have to cast otherList from a List<T> type to a ArrayList<T> type or LinkedList<T>.
     * <p>
     * After checking for possible errors, you're first few lines of code should be:
     * LinkedList<T> other = (LinkedList<T>) otherList; or ArrayList<T> other = (Arraylist<T>) otherList;
     * this.sort();
     * this.removeDuplicates();
     * other.sort();
     * other.removeDuplicates();
     *
     * @param otherList the other list that this operation is being performed on.
     */
    @Override
    public void exclusiveOr(List<T> otherList) {
        if(otherList.isEmpty())
            return;


    }

    /**
     * Returns the minimum value of the List
     * If the list is empty, return NULL.
     * Note, consider how sorting can affect runtime or optimize this solution
     */
    @Override
    public T getMin() {
        if(isEmpty())
            return null;
        Node<T> min = head.getNext();
        Node<T> current = head.getNext();
        while(current.getNext() != null){
            current = current.getNext();
            if(current.getData().compareTo(min.getData()) == -1)
                min = current;
        }
        return min.getData();
    }

    /**
     * Returns the maximum value of the List
     * Note, consider how sorting can affect runtime or optimize this solution
     */
    @Override
    public T getMax() {
        if(isEmpty())
            return null;

        Node<T> max = head.getNext();
        Node<T> current = head.getNext();
        while(current.getNext() != null){
            current = current.getNext();
            if(current.getData().compareTo(max.getData()) == 1)
                max = current;
        }
        return max.getData();
    }

    /**
     * Simply returns the isSorted attribute.
     *
     * @return isSorted boolean attribute.
     */
    @Override
    public boolean isSorted() {
        return isSorted;
    }
}