import java.util.Scanner;
public class                      Game {
    public static void main(String[] args) {
        Board chessboard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", chessboard); // initializes the board.

        Scanner scanner = new Scanner(System.in);
        boolean legalMove;     //
        int startRow;
        int startCol;
        int endRow;
        int endCol;
        String whoWon;
        while(true){
            System.out.println(chessboard);
            System.out.println("It's currently white's turn to play.");
            System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])");

            legalMove = false;
            while (!legalMove) { // loops until the player makes a legal move.
                while (true) { // loops until the user inputs the right format.
                    try {
                        String input = scanner.nextLine();
                        String[] parts = input.split(" ");
                        startRow = Integer.parseInt(parts[0]);
                        startCol = Integer.parseInt(parts[1]);
                        endRow = Integer.parseInt(parts[2]);
                        endCol = Integer.parseInt(parts[3]);
                        break;
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please try again");
                    }
                }
                legalMove = chessboard.movePiece(startRow, startCol, endRow, endCol); // legal move is updated based on whether the player made a valid move or not.
                if (legalMove) {
                    chessboard.getPiece(endRow, endCol).promotePawn(endRow, false); // checks for pawn promotion.
                } else
                    System.out.println("Invalid input. Please try again");
            }
            if (chessboard.isGameOver()) { // stops the game if the game is over.
                whoWon = "Black";
                break;
            }
            System.out.println(chessboard);
            System.out.println("It's currently Black's turn to play.");
            System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])\n");

            legalMove = false;
            while (!legalMove) {
                while (true) { // loops until the user inputs the right format.
                    try {
                        String input = scanner.nextLine();
                        String[] parts = input.split(" ");
                        startRow = Integer.parseInt(parts[0]);
                        startCol = Integer.parseInt(parts[1]);
                        endRow = Integer.parseInt(parts[2]);
                        endCol = Integer.parseInt(parts[3]);
                        break;
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please try again");
                    }
                }
                legalMove = chessboard.movePiece(startRow, startCol, endRow, endCol);
                if (legalMove) {
                    System.out.println(chessboard);
                    chessboard.getPiece(endRow, endCol).promotePawn(endRow, true); // checks for pawn promotion.
                } else
                    System.out.println("Invalid input. Please try again");
            }
            if (chessboard.isGameOver()) { // stops the game if the game is over
                whoWon = "Black";
                break;
            }
        }
        System.out.println(whoWon + " won the game");
    }
}

