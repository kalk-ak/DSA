public class LinkedCircularQueue<E> implements CircularQueue<E> {
    CircularLinkedList<E> data = new CircularLinkedList();
    public LinkedCircularQueue() { }
    @Override
    public void rotate() {
        data.rotate();
    }
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }
    @Override
    public E dequeue() {
        return data.removeFirst();
    }
    @Override
    public E first() {
        return data.first();
    }
    @Override
    public int size() {
        return data.size();
    }
    @Override
    public boolean isEmpty() {
        return (data.size() == 0);
    }
}
