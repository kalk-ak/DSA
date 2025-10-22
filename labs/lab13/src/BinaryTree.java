import java.math.*;
public class BinaryTree {

    // TODO complete this method
    public static boolean isValid(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            return true;
        else {
            int counter = 1;
            while (arr.length > Math.pow(2, counter) - 1)
                counter++;
            if (arr.length != Math.pow(2, counter) - 1)
                return false;
            else {
                int index = 0;
                int min = Integer.MIN_VALUE;
                int max = Integer.MAX_VALUE;
                return BinaryTree.isValidHelper(arr, index, min, max);

            }


        }
    }
    private static boolean isValidHelper(int[] arr, int index, int min, int max) {
        if (index >= arr.length)
            return true;
        int val = arr[index];
        if (val < min || val > max)
            return false;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        return (left >= arr.length || (arr[left] <= val && isValidHelper(arr, left, min, val))) &&
                (right >= arr.length || (arr[right] >= val && isValidHelper(arr, right, val, max)));
    }





    public static void main (String args[]) {
      // milestone 1
      int[] arr1 = new int[]{7,4,10,3,6,8,15};
      int[] arr2 = new int[]{20,12,32,5,18,25,38};
      int[] arr3 = new int[]{11,3,33,2,8,10,44};
      int[] arr4 = new int[]{55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};

      System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
      System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
      System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
      System.out.println("arr4 valid: " + isValid(arr4));  // expected: false
    }
}
