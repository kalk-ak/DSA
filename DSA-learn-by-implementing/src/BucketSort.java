import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


public class BucketSort {
    public static void sort(Integer[] sequence) throws UnsupportedOperationException{
        final Queue<Integer>[] bucket;
        bucket = new Queue[sequence.length];        // bucket to store elements is size to the number of elements in sequence
        for (int i : sequence) {
            if ((i / 10) != 0)          // checks if each element in the sequence is single digit
                throw new UnsupportedOperationException("Sequence to be sorted can only be singe digit");
            if (bucket[i] == null)  // if queue is not initialized, creates one
                bucket[i] = new LinkedList<>();
            bucket[i].add(i);
        }
        for (int i=0, j=0; i < bucket.length; i++) {       // i=index of bucket, j=index of sorted sequence
            if (bucket[i] != null)

                while (!bucket[i].isEmpty()) {
                    sequence[j] = bucket[i].remove();
                    j++;        // j is only incremented when element is inserted in the original sequence
                }
        }


    }
}
