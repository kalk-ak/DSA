public class DoublyLinkedList<E> {
    public static class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {return element;}
        public Node<E> getNext() {return next;}
        public Node<E> getPrev() {return prev;}
        public void setPrev(Node<E> n) {prev = n;}
        public void setNext(Node<E> n) {next= n;}
        public void setElement(E e) {element = e;}
    }
    private Node<E> head;
    private Node<E> tail;

    private int size = 0;

    public DoublyLinkedList(){
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }
    /** checks if the list has elements */
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    /** returns the first element of the Doubly linked list */
    public E first() {
        if (isEmpty()) {return null;}
        Node<E> first = head.getNext();
        return first.getElement();
    }
    /** returns the last element of the Doubly linked list */
    public E last() {
        if (isEmpty()) {return null;}
        Node<E> last = tail.getPrev();
        return last.getElement();
    }
    /** utility method*/
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addFirst(E e){
        addBetween(e, head, head.getNext());
    }

    public void addLast(E e){
        addBetween(e, tail.getPrev(), tail);
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();

    }
    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(head.getNext());
    }

    public E removeLast(){
        if (isEmpty()) return null;
        return remove(tail.getPrev());
    }




}
