import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class KthSmallest {
    /** selects the Kth smallest element from a list
     * @param k
     * @param list the list we are selecting from
     * @return the selected element
     * @param <E>
     */
    public static <E> E select(int k, ArrayList<E> list, Comparator<E> comp) {
        if (list == null || k < 0 || k >= list.size())
            throw new IllegalArgumentException("Invalid input");
        if (list.size() == 0)       // if list is empty
            return null;
        if (list.size() == 1)
            return list.get(0);
        E pivot = list.get(0);      // selects the first element as the pivot from unsorted list
        ArrayList<E> left = new ArrayList<>();
        ArrayList<E> mid = new ArrayList<>();
        ArrayList<E> right = new ArrayList<>();

        int c;
        for (E element : list) {
            c = comp.compare(element, pivot);
            if (c < 0)      // element is less than pivot hence added at left list
                left.add(element);
            else if (c == 0)
                mid.add(element);
            else
                right.add(element);
        }
        if (k < left.size())        // kth smallest element is in the left list
            return select(k, left, comp);
        else if (k <= (left.size() + mid.size()))       // kth smallest element is not in the left list but rather on the mid
            return select(k - left.size(), left, comp);        // size of left list is subtracted from K because of the removed elements
        else
            return select(k - (left.size() + mid.size()), right, comp);
    }
    public static <E> E select(int k, ArrayList<E> list) {
        Comparator<E> comp = new DefaultComparator<>();
        if (list == null || k < 0 || k >= list.size())
            throw new IllegalArgumentException("Invalid input");
        if (list.size() == 0)       // if list is empty
            return null;
        if (list.size() == 1)
            return list.get(0);
        E pivot = list.get(0);      // selects the first element as the pivot from unsorted list
        ArrayList<E> left = new ArrayList<>();
        ArrayList<E> mid = new ArrayList<>();
        ArrayList<E> right = new ArrayList<>();

        int c;
        for (E element : list) {
            c = comp.compare(element, pivot);
            if (c < 0)      // element is less than pivot hence added at left list
                left.add(element);
            else if (c == 0)
                mid.add(element);
            else
                right.add(element);
        }
        if (k < left.size())        // kth smallest element is in the left list
            return select(k, left, comp);
        else if (k <= (left.size() + mid.size()))       // kth smallest element is not in the left list but rather on the mid
            return select(k - left.size(), left, comp);        // size of left list is subtracted from K because of the removed elements
        else
            return select(k - (left.size() + mid.size()), right, comp);
    }

    public static <E> E select(int k, LinkedList<E> list, Comparator<E> comp) {
        if (list == null || k < 0 || k >= list.size())
            throw new IllegalArgumentException("Invalid input");
        if (list.isEmpty())       // if list is empty
            return null;
        if (list.size() == 1)
            return list.get(0);
        E pivot = list.get(0);      // selects the first element as the pivot from unsorted list

        Queue<E> left = new LinkedList<>();
        Queue<E> mid = new LinkedList<>();
        Queue<E> right = new LinkedList<>();

        int c;
        for (E element : list) {
            c = comp.compare(element, pivot);
            if (c < 0)      // element is less than pivot hence added at left list
                left.add(element);
            else if (c == 0)
                mid.add(element);
            else
                right.add(element);
        }

        if (k < left.size())        // kth smallest element is in the left list
            return select(k, (LinkedList<E>)left, comp);
        else if (k <= (left.size() + mid.size()))       // kth smallest element is not in the left list but rather on the mid
            return select(k - left.size(), (LinkedList<E>)mid, comp);        // size of left list is subtracted from K because of the removed elements
        else
            return select(k - (left.size() + mid.size()), (LinkedList<E>)right, comp);
    }

    public static <E> E select(int k, LinkedList<E> list) {
        Comparator<E> comp = new DefaultComparator<>();
        if (list == null || k < 0 || k >= list.size())
            throw new IllegalArgumentException("Invalid input");
        if (list.isEmpty())       // if list is empty
            return null;
        if (list.size() == 1)
            return list.get(0);
        E pivot = list.get(0);      // selects the first element as the pivot from unsorted list

        Queue<E> left = new LinkedList<>();
        Queue<E> mid = new LinkedList<>();
        Queue<E> right = new LinkedList<>();

        int c;
        for (E element : list) {
            c = comp.compare(element, pivot);
            if (c < 0)      // element is less than pivot hence added at left list
                left.add(element);
            else if (c == 0)
                mid.add(element);
            else
                right.add(element);
        }

        if (k < left.size())        // kth smallest element is in the left list
            return select(k, (LinkedList<E>)left, comp);
        else if (k <= (left.size() + mid.size()))       // kth smallest element is not in the left list but rather on the mid
            return select(k - left.size(), (LinkedList<E>)mid, comp);        // size of left list is subtracted from K because of the removed elements
        else
            return select(k - (left.size() + mid.size()), (LinkedList<E>)right, comp);
    }



}
