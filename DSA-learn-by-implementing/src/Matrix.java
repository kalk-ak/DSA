import java.util.Arrays;
public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows, int ncols) {
        this.nrows = nrows;
        this.ncols = ncols;
        matrix = new int[nrows][ncols];
    }


    public Matrix(int[][] arr) {
        matrix = arr;
        nrows = matrix.length;
        ncols = arr[0].length;

    }


    public Matrix transpose() {
        Matrix transpoesdMatrix = new Matrix(ncols, nrows);
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {
                transpoesdMatrix.matrix[j][i] = matrix[i][j];
            }
        }
        return transpoesdMatrix;

    }


    public String toString() {
        String s = "";
        for (int i = 0; i < nrows; i++){
            for (int j = 0; j < ncols; j++){
                s += matrix[i][j] + " ,";
            }
            s += "\n";

        }
        return s;
    }

    public static void main(String[] args) {
        Matrix myMatrix = new Matrix(5,5);
        myMatrix.matrix[0][1] = 2;
        myMatrix.matrix[1][2] = 4;
        myMatrix.matrix[4][1] = 5;
        myMatrix.matrix[1][0] = 1;

        System.out.println(myMatrix);
        System.out.println(myMatrix.transpose());
    }
}




