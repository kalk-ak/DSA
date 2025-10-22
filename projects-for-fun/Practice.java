import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Practice<E> {


    public static void main(String[] args) {
        Comparator<String> comp = new StringLengthComparator();
        PriorityQueue<String> heaps = new PriorityQueue<>(comp);
        heaps.add("224");
        heaps.add("63");
        heaps.add("2433");
        heaps.add("15333");
        heaps.add("1333333");
        heaps.add("103");
        System.out.println(heaps.poll());
        System.out.println(heaps.peek());
        heaps.add("1");
        System.out.println((heaps.size()));
        System.out.println(heaps.peek());

        System.out.println();

        for (Object o : heaps) {
            System.out.println(o);
        }
        System.out.println(heaps.comparator());






    }
}
