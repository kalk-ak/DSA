package src;
import java.util.ArrayList;

public class LearningInsertion {

    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++){
            int k = i;
            int curr = arr[k];
            while (k > 0 && arr[k] < arr[k-1]){
                arr[k] = arr[k-1];
                k--;
            }
            arr[k] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        for (int i : arr) {
            System.out.println(i);
        }
        LearningInsertion.insertionSort(arr);
        System.out.println();

        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println(System.nanoTime());
    }
}
