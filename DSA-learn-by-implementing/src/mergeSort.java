import java.util.Arrays;
import java.util.Comparator;

public class mergeSort {
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];
        }
    }

    public static <K> void sort(K[] S, Comparator<K> comp ) {
        int n = S.length;
        if (n < 2)              // Array is trivially sorted
            return;

        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);         // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, S.length);          // copy of second half

        sort(S1, comp);         // sort copy of first half
        sort(S2, comp);         // sort copy of second half

        // merge results
        merge(S1, S2, S, comp);
    }

    public static <K> void sort(K[] S) {
        Comparator<K> comp = new DefaultComparator<>();
        int n = S.length;
        if (n < 2)              // Array is trivially sorted
            return;

        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);         // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, S.length);          // copy of second half

        sort(S1, comp);         // sort copy of first half
        sort(S2, comp);         // sort copy of second half

        // merge results
        merge(S1, S2, S, comp);
    }

    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0)       // The first element of S1 is smaller
                S.enqueue(S1.dequeue());                        // hence it is removed from s1 and added to S
            else
                S.enqueue(S2.dequeue());        // takes the next element from S2
        }
        if (S1.isEmpty())                       // moves any element that remains in S1 or S2
            while (!S2.isEmpty())
                S.enqueue(S2.dequeue());
        else
            while (S2.isEmpty())
                S.enqueue(S2.dequeue());
        }

        /** Merge-sort contents of queue */
        public static <K> void sort(Queue<K> S, Comparator<K> comp) {
            int n = S.size();
            if (n < 2)
                return;             // queue is trivially sorted

            // divide
            Queue<K> S1 = new LinkedQueue<>();
            Queue<K> S2 = new LinkedQueue<>();
            while (S1.size() < n /2)
                S1.enqueue(S.dequeue());        // move the first n/2 elements to S1
            while (!S.isEmpty())
                S2.enqueue(S.dequeue());        // move the remaining elements to S2

            // conquer
            sort(S1, comp);
            sort(S2, comp);

            // merge results
            merge(S1, S2, S, comp);
    }

    public static <K> void sort(Queue<K> S) {
        Comparator<K> comp = new DefaultComparator<>();
        int n = S.size();
        if (n < 2)
            return;             // queue is trivially sorted

        // divide
        Queue<K> S1 = new LinkedQueue<>();
        Queue<K> S2 = new LinkedQueue<>();
        while (S1.size() < n /2)
            S1.enqueue(S.dequeue());        // move the first n/2 elements to S1
        while (!S.isEmpty())
            S2.enqueue(S.dequeue());        // move the remaining elements to S2

        // conquer
        sort(S1, comp);
        sort(S2, comp);

        // merge results
        merge(S1, S2, S, comp);
    }
}