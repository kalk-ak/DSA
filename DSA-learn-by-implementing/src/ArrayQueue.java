import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {

    public void enqueue(E e) throws IllegalStateException{
        if (sz == data.length) throw new IllegalStateException();
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
    public boolean isEmpty() { return sz == 0; }
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }
    public int size() { return sz; }


    public ArrayQueue() {this (CAPACITY);}
    public ArrayQueue(int cap) {
        data = (E[]) new Object[cap];
    }
    private int sz = 0;
    private int f = 0;
    private E[] data;
    private static final int CAPACITY = 1000;


}
