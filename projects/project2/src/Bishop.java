public class Bishop {
    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return board.verifyDiagonal(row, col, endRow, endCol) &&
                board.verifySourceAndDestination(row, col, endRow, endCol, isBlack);
    }
    int row;
    int col;
    boolean isBlack;


}
