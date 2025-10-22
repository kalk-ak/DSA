import java.util.Comparator;
import java.util.Arrays;

public class InsertionSort {
    // Insert.java
// insertion sort
// Revised 2/2020

    /** Sorts in non-descending order using insertion sort: o(n^2) average/worst */
    public static <K> void sort(K[] sequence, Comparator<K> comp) {
        for (int i=0; i < sequence.length; i++) {
            K temp;
            int j = i + 1;
            while (j > 0 && j < sequence.length && (comp.compare(sequence[j], sequence[j-1])) < 0) {       // T
                temp = sequence[j]; sequence[j] = sequence[j-1]; sequence[j-1] = temp;
                j--;
            }
        }
    }
    public static <K> void sort(K[] sequence) {
        Comparator<K> comp = new DefaultComparator<>();
        for (int i=0; i < sequence.length; i++) {
            K temp;
            int j = i + 1;
            while (j > 0 && j < sequence.length && (comp.compare(sequence[j], sequence[j-1])) < 0) {       // T
                temp = sequence[j]; sequence[j] = sequence[j-1]; sequence[j-1] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        Integer[] array = {5, 3, 8, 2, 1, 7, 4, 6};

        // Create a Comparator for integers (ascending order)

        // Sort the array using the sort method
        sort(array);

        // Print the sorted array
        System.out.println(Arrays.toString(array));
    }

}
