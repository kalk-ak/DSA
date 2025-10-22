public class SinglyLinkedLists<E> implements Cloneable{
    private static class Node<E>  {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {return element;}
        public Node<E> getNext() {return next;}
        public void setNext(Node<E> n){next = n;}
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedLists() {}

    // accessor methods
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E first(){
        if (isEmpty()) return null;
        return head.getElement();
    }
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    public void addFirst(E e){
        head = new Node<>(e, head);
        if (isEmpty())
            tail = head;
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<> (e, null);
        if (size == 0)
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.element;
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    public boolean equals(Object o){
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinkedLists other = (SinglyLinkedLists) o;
        if (size != other.size) return false;
        Node walkA = head;
        Node walkB = other.head;
        while (walkA != null) {
            if (!(walkA.getElement().equals(walkB.getElement()))) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }
    public SinglyLinkedLists<E> clone() throws CloneNotSupportedException {
        SinglyLinkedLists<E> other = (SinglyLinkedLists<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            other.tail = other.head;
            Node<E> walk = head.getNext();
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                other.tail.setNext(newest);
                other.tail = newest;
                other.tail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }
}
