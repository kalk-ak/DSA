public class LinkedStackInterface<E> implements StackInterface<E> {
    private SinglyLinkedLists<E> list = new SinglyLinkedLists<>();
    public LinkedStackInterface() { }
    public int size() { return list.size(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void push(E element) { list.addFirst(element); }

    public E top() { return list.first(); }

    public E pop() { return list.removeFirst(); }

  /*  public static boolean isHTMLMatched(String html) {
        Stack2<String> buffer = new LinkedStack<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j+1);
            if (k == -1)
                return false;
            String tag = html.substring(j +1, k);
            if (!tag.startsWith("/"))
                buffer.push(tag);
            else {
                if (buffer.isEmpty())
                    return false;
                if (!tag.substring(1).equals(buffer.pop()))
                    return false;
            }
            j = html.indexOf('<', k+1);
        }
        return buffer.isEmpty();
    }
*/

}
