public class LinkedQueue<E> implements Queue<E> {
    public LinkedQueue() { }
    public void enqueue(E e) {
        data.addLast(e);
    }

    public E dequeue() {
        return data.removeFirst();
    }

    public int size() {
        return data.size();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public E first() {
        return data.first();
    }

    SinglyLinkedLists<E> data = new SinglyLinkedLists<>();
}
