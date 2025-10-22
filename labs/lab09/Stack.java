public class Stack<T>{

    private Node<T> head = new Node<>();
    public Stack(int size){
      this.size = size;
    }
    public Stack() {size = 5;}
    public T pop(){
        if (numNodes == 0) return null;
       Node<T> out = head;
       head = head.getNext();
       numNodes--;
       return out.getData();
    }

    public int getSize(){
        return size;
    }
    public void push(T item) throws StackException{
        if (numNodes >= size) throw new StackException(size);
        Node<T> newest = new Node<>(item, head);
        head = newest;
        numNodes++;
    }

    private int size;
    private int numNodes = 0;

}

