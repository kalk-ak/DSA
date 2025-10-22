import java.util.Scanner;

public class Piece {
    private int row;
    private int col;
    private boolean isBlack;
    private char character;


    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public char getCharacter(){
        return character;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return isBlack;
    }

    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn(int row, boolean isBlack) {
        if (character == '\u265f' || character == '\u2659') {   // checks if the pieces is a pawn
            if (isBlack && row == 7) {     // checks if the piece is black and at the end of the row
                Scanner scanner = new Scanner(System.in);
                System.out.println("Pawn is promoted");
                int chosen = 0;
                while (chosen != 1 && chosen != 2 && chosen != 3 && chosen != 4) { // makes sure the user inputs a valid input
                    System.out.println("Choose one of the following\n" +
                            "1. Queen\n" +
                            "2. Rook\n" +
                            "3. Knight\n" +
                            "4. Bishop\n" +
                            "input 1, 2, 3, or 4");
                    String input = scanner.nextLine();
                    try {
                        chosen = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                    }
                }
                switch (chosen) { // changes the pawn
                    case 1:
                        character = '\u265b';
                        break;
                    case 2:
                        character = '\u265c';
                        break;
                    case 3:
                        character = '\u265e';
                        break;
                    case 4:
                        character = '\u265d';
                        break;
                    default:
                        break;
                }
            } else if (row == 0) {  // checks if the white pawn reaches the end.
                Scanner scanner = new Scanner(System.in);
                System.out.println("Pawn is promoted");
                int chosen = 4;
                while (chosen != 1 && chosen != 2 && chosen != 3 && chosen != 4) { // makes sure the user inputs a valid input
                    System.out.println("Choose one of the following\n" +
                            "1. Queen\n" +
                            "2. Rook\n" +
                            "3. Knight\n" +
                            "4. Bishop\n" +
                            "input 1, 2, 3, or 4");
                    String input = scanner.nextLine();
                    try {
                        chosen = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                    }
                }
                switch (chosen) { // changes the pawn
                    case 1:
                        character = '\u2655';
                        break;
                    case 2:
                        character = '\u2656';
                        break;
                    case 3:
                        character = '\u2658';
                        break;
                    case 4:
                        character = '\u2657';
                        break;
                    default:
                        break;
                }
            }
        }
    }
    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + this.character;
    }


}
