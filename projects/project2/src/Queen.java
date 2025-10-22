public class Queen {
    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if (!board.verifySourceAndDestination(row, col, endRow, endCol, isBlack))
            return false;
        if(board.verifyAdjacent(row, col, endRow, endCol))
            return true;
        if(board.verifyVertical(row, col, endRow, endCol))
            return true;
        if(board.verifyHorizontal(row, col, endRow, endCol))
            return true;
        return board.verifyDiagonal(row, col, endRow, endCol);
    }
    int row;
    int col;
    boolean isBlack;
}
