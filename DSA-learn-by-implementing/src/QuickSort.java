import java.util.Comparator;

public class QuickSort {
    public static <K> void sort(Queue<K> S, Comparator<K> comp) {
        if (S.size() < 2)           //Queue is trivially sorted
            return;

        // divide
        K pivot = S.first();        // using first element as pivot
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();

        while (S.isEmpty()) {
            K element = S.dequeue();
            int result = comp.compare(element, pivot);
            if (result < 0)     // element is less than pivot
                L.enqueue(element);
            else if (result == 0)   // element is equal to pivot
                E.enqueue(element);
            else        // element is greater than pivot
                G.enqueue(element);
        }

        // conquer
        sort(L, comp);          // sort elements less than pivot
        sort(G, comp);          // sort elements greater than pivot

        // concatenate results
        while (!L.isEmpty())
            S.enqueue(L.dequeue());
        while (!E.isEmpty())
            S.enqueue(E.dequeue());
        while (!G.isEmpty())
            S.enqueue(G.dequeue());
    }

    public static <K> void sort(K[] S, Comparator comp, int a, int b) {
        if (a >= b)         // subarray is trivially sorted
            return;
        K pivot = S[b];
        K temp;
        int left = a;
        int right = b;
        while (left <= right) {
            // scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && (comp.compare(S[left], pivot) < 0))     // Item on the left is less than pivot and
                left++;                                                     // left pointer is before right pointer
            while (left <= right && (comp.compare(S[right], pivot) > 0))
                right--;

            if (left <= right) {
                // swap values and shrink range
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++; right++;
            }
            // put pivot into its final place (currently marked by left index)
            temp = S[left]; S[left] = S[b]; S[b] = temp;

            // make recursive calls
            sort(S, comp, a, left -1);
            sort(S, comp, left + 1, b);
        }
    }
}
