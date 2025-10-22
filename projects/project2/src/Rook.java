public class Rook {

    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        return board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                board.verifyHorizontal(row, col, endRow, endCol);
    }
    int row;
    int col;
    boolean isBlack;
}
