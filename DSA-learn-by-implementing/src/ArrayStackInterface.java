import java.util.Arrays;
public class ArrayStackInterface<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    // constructors
    public ArrayStackInterface() { this(CAPACITY); }
    public ArrayStackInterface(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() { return (t + 1);}
    /** Adds an element at the top of the stack.*/
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        t++;
        data[t] = e;
    }

    /** Returns, but does not remove, the element at the top of the stack. */
     public E top() {
         if (isEmpty()) return null;
         return data[t];
     }
     public E pop() {
         if (isEmpty()) return null;
         E answer = data[t];
         data[t] = null;
         t--;
         return answer;
     }
   public static <E> void reverse(E[] a){
         StackInterface<E> buffer = new ArrayStackInterface<>(a.length);
         for (int i=0; i < a.length; i++)
             buffer.push(a[i]);
         for (int i=0; i < a.length; i++)
             a[i] = buffer.pop();
   }

   public static boolean isMatched(String expression) {
         final String opening = "({[";
         final String closing = ")}]";
         StackInterface<Character> buffer = new LinkedStackInterface<>();
         for (char c : expression.toCharArray()) {
             if (opening.indexOf(c) != -1)
                 buffer.push(c);
             else if (closing.indexOf(c) != -1)
                 if (buffer.isEmpty())
                     return false;
                 if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                     return false;
         }
         return buffer.isEmpty();
   }


    public static void main(String[] args) {
        StackInterface<Integer> S = new ArrayStackInterface<>();  // contents: ()
        S.push(5);                              // contents: (5)
        S.push(3);                              // contents: (5, 3)
        System.out.println(S.size());           // contents: (5, 3)        outputs 2
        System.out.println(S.pop());            // contents: (5)           outputs 3
        System.out.println(S.isEmpty());        // contents: (5)           outputs false
        System.out.println(S.pop());            // contents: ()            outputs 5
        System.out.println(S.isEmpty());        // contents: ()            outputs true
        System.out.println(S.pop());            // contents: ()            outputs null
        S.push(7);                              // contents: (7)
        S.push(9);                              // contents: (7, 9)
        System.out.println(S.top());            // contents: (7, 9)        outputs 9
        S.push(4);                              // contents: (7, 9, 4)
        System.out.println(S.size());           // contents: (7, 9, 4)     outputs 3
        System.out.println(S.pop());            // contents: (7, 9)        outputs 4
        S.push(6);                              // contents: (7, 9, 6)
        S.push(8);                              // contents: (7, 9, 6, 8)
        System.out.println(S.pop());            // contents: (7, 9, 6)     outputs 8

        System.out.println("testing reversal array using stacks");
        Integer[] a = {4, 8, 15, 16, 23, 42};  // autoboxing allows this
        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Reversing...");
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));

    }


}
