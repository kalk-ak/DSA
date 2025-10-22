import java.util.ArrayDeque;
import java.util.Queue;

public class ColorPath {
    public static int[][] colorPath(int[][] image, int sourceRow, int sourceCol, int newColor) {
        int sourceColor = image[sourceRow][sourceCol];
        bfs(image,sourceRow, sourceCol, newColor);
        //dfs(image, sourceRow, sourceCol, sourceColor, newColor);
        return image;
    }

    public static void bfs(int[][] arr, int row, int col, int newColor) {
        Queue<int[]> myQ = new ArrayDeque<>();
        int[] temp = {row, col};
        myQ.add(temp);

        int oldColor = arr[row][col];
        while (!myQ.isEmpty()) {
            int[] cord= myQ.remove();
            if(arr[cord[0]][cord[1]] != oldColor)
                continue;
            arr[cord[0]][cord[1]] = newColor;
            if ( cord[1] + 1 < arr[0].length) {
                temp = new int[]{cord[0], cord[1] + 1};
                myQ.add(temp);
            }
            if  (cord[1] - 1 >= 0){
                temp = new int[]{cord[0], cord[1] - 1};
                myQ.add(temp);
            }
            if (cord[0] + 1 < arr.length) {
                temp = new int[]{cord[0] + 1, cord[1]};
                myQ.add(temp);
            }
            if (cord[0] - 1 >= 0) {
                temp = new int[]{cord[0] - 1, cord[1]};
                myQ.add(temp);

            }
        }
    }

    public static void dfs(int[][] arr, int row, int col, int oldColor, int newColor){
       if ((row < 0 || row >= arr.length) || (col < 0 || col >= arr[0].length) || arr[row][col] != oldColor)
           return;
       arr[row][col] = newColor;
       dfs(arr, row, col - 1,oldColor, newColor);
       dfs(arr, row, col + 1, oldColor,newColor);
       dfs(arr, row + 1, col,oldColor, newColor);
       dfs(arr, row - 1, col, oldColor, newColor);
    }
}
