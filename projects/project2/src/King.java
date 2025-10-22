public class King {
    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row, col, endRow, endCol, isBlack))
            return board.verifyAdjacent(row, col, endRow, endCol);
        return false;
    }
    int row;
    int col;
    boolean isBlack;
}


