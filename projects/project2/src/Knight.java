import java.lang.Math;
public class Knight {

    public Knight(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (Math.abs((Math.abs(row - endRow) - Math.abs((col - endCol)))) == 1)
            return board.verifySourceAndDestination(row, col, endRow, endCol, isBlack);
        return false;
    }
    int row;
    int col;
    boolean isBlack;
}
