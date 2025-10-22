import java.lang.Math;
public class Board {

    // Instance variables
    private final Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    // Accessor Methods


    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }


    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods


    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. A constraint of a legal move is:
    // - there exists a Piece at (startRow, startCol) and the destination square is seizable.
    // Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move is legal,
    // and to execute the move if it is.
    // Your Game class should not directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (board[startRow][startCol] == null) return false;
        if (board[startRow][startCol].isMoveLegal(this, endRow, endCol)) {
            board[endRow][endCol] = board[startRow][startCol];
            board[startRow][startCol] = null;
            board[endRow][endCol].setPosition(endRow, endCol);
            return true;
        }
        return false;
    }


    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        int numOfKings = 0;
        char unicode;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null) {
                    unicode = board[i][j].getCharacter();
                    if (unicode == '\u2654' || unicode == '\u265A')
                        numOfKings++;
                }
            }
        }
        return numOfKings != 2;
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for (int i = 0; i < 8; i++) {
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for (int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for (int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }


    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = null;
        }
    }
    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    // - where 'start' = (startRow, startCol) and 'end' = (endRow, endCol)
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0) return false;
        if (startRow > 7 || startCol > 7 || endRow > 7 || endCol > 7) return false;
        if (board[startRow][startCol] == null) return false;
        if (startRow == endRow && startCol == endCol) return false;

        if (board[endRow][endCol] == null) return true;
        return board[startRow][startCol].getIsBlack() != board[endRow][endCol].getIsBlack();
    }


    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        return Math.abs((startRow - endRow)) <= 1 && Math.abs((startCol - endCol)) <= 1;
    }


    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow != endRow || startCol == endCol)
            return false;

        int start = Math.min(startCol, endCol) + 1;
        int end = Math.max(startCol, endCol);
        for (int i = start; i < end; i++)
            if (board[startRow][i] != null) return false;
        return true;
    }


    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol != endCol || startRow == endRow)
            return false;
        int start = Math.min(startRow, endRow) + 1;
        int end = Math.max(startRow, endRow);

        for (int i = start; i < end; i++)
            if (board[i][startCol] != null) return false;
        return true;
    }


    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol))
            return false;
        if (startRow - endRow == 0 && startCol - endCol == 0)    // checks if the start and end are at the same place.
            return false;

        int rowDirection = (endRow - startRow) / Math.abs(endRow - startRow);
        int colDirection = (endCol - startCol) / Math.abs(endCol - startCol);

        // Check each square along the diagonal for a piece
        int currentRow = startRow + rowDirection;
        int currentCol = startCol + colDirection;
        while (currentRow != endRow && currentCol != endCol) {
            if (board[currentRow][currentCol] != null)
                return false;
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;
    }
}
