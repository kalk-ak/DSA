public class CircularLinkedList<E> {
    public static class Node<E> {
        E element = null;
        Node<E> next = null;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getElement() {
            return element;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularLinkedList() {
    }

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
            tail = newest;
        }
        size++;
    }
    public E removeFirst(){
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();

        if (tail.getNext() == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();

    }
}
