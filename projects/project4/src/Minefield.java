import java.util.Queue;
import java.util.Random;

public class Minefield {
    /**
    Global Section
    */
    public static final String ANSI_YELLOW_BRIGHT = "\u001B[33;1m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE_BRIGHT = "\u001b[34;1m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_RED_BRIGHT = "\u001b[31;1m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001b[47m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001b[45m";
    public static final String ANSI_GREY_BACKGROUND = "\u001b[0m";

    /* 
     * Class Variable Section
     * 
    */

    /*Things to Note:
     * Please review ALL files given before attempting to write these functions.
     * Understand the Cell.java class to know what object our array contains and what methods you can utilize
     * Understand the StackGen.java class to know what type of stack you will be working with and methods you can utilize
     * Understand the QGen.java class to know what type of queue you will be working with and methods you can utilize
     */
    
    /**
     * Minefield
     * 
     * Build a 2-d Cell array representing your minefield.
     * Constructor
     * @param rows       Number of rows.
     * @param columns    Number of columns.
     * @param flags      Number of flags, should be equal to mines
     */
    public Minefield(int rows, int columns, int flags) {
        minefield = new Cell[rows][columns];
        numMines = flags;
        numFlags = flags;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                minefield[i][j] = new Cell(false, " - ");
            }
        }

    }

    /**
     * evaluateField
     * 
     *
     * @function:
     * Evaluate entire array.
     * When a mine is found check the surrounding adjacent tiles. If another mine is found during this check, increment adjacent cells status by 1.
     * 
     */
    public void evaluateField() {
        int m;
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j++) {
                m = 0;
                Cell currCell = minefield[i][j];
                if (!currCell.getStatus().equals("M")) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if (x + i >= 0 && x + i < minefield.length && y + j >= 0 && y + j < minefield[0].length && minefield[x + i][y + j].getStatus().equals("M")) {

                                m++;
                            }
                        }
                    }
                    minefield[i][j].setStatus(Integer.toString(m));
                }
            }
        }
    }


    /**
     * createMines
     * 
     * Randomly generate coordinates for possible mine locations.
     * If the coordinate has not already been generated and is not equal to the starting cell set the cell to be a mine.
     * utilize rand.nextInt()
     * 
     * @param x       Start x, avoid placing on this square.
     * @param y        Start y, avoid placing on this square.
     * @param mines      Number of mines to place.
     */
    public void createMines(int x, int y, int mines) {
        Random random = new Random();
        int numOfSuccess = 0;

        int i;
        int j;
        while (numOfSuccess < mines) {
            i = random.nextInt(x);
            j = random.nextInt(y);
            if (minefield[i][j].equals("M") || (minefield[i][j].getRevealed() == true))
                continue;
            else {
                minefield[i][j].setStatus("M");
                numOfSuccess++;
            }
        }
    }

    //------------------------ utility method to check x, y is in bound
    public boolean isInbound(int row, int col) {
        if (row >= minefield.length || col >= minefield[0].length || row < 0 || col < 0) {
            System.out.println("Index out of bounds");
            return false;
        } else
            return true;
    }

    /**
     * guess
     * 
     * Check if the guessed cell is inbounds (if not done in the Main class). 
     * Either place a flag on the designated cell if the flag boolean is true or clear it.
     * If the cell has a 0 call the revealZeroes() method or if the cell has a mine end the game.
     * At the end reveal the cell to the user.
     * 
     * 
     * @param x       The x value the user entered.
     * @param y       The y value the user entered.
     * @param flag    A boolean value that allows the user to place a flag on the corresponding square.
     * @return boolean Return false if guess did not hit mine or if flag was placed, true if mine found.
     */
    public boolean guess(int x, int y, boolean flag) {
        if (!isInbound(x, y)) {
            return false;
        }
        if (minefield[x][y].getRevealed() == true) {
            System.out.println("Spot already revealed");
            return false;
        }
        if (flag) {
            if (numFlags <= 0) {
                System.out.println("There aren't any remaining flags");
                return false;
            } else {
                minefield[x][y].setStatus("F");
                minefield[x][y].setRevealed(true);
                numFlags--;
                return true;
            }
        } else {
            if (minefield[x][y].getStatus().equals("0"))
                revealZeroes(x, y);
            else if (minefield[x][y].getStatus().equals("M")) {
                gameOver = true;
                minefield[x][y].setRevealed(true);
            } else {
                minefield[x][y].setStatus("" + getMineNum(x, y));
                minefield[x][y].setRevealed(true);
            }

            return true;
        }

    }
    //-------------helper private method to get the number of mines around a spot
    protected int getMineNum(int x, int y) {
        int count = 0;
        int numRows = minefield.length;
        int numCols = minefield[0].length;

        for (int i = Math.max(0, x - 1); i <= Math.min(numRows - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(numCols - 1, y + 1); j++)
                if (minefield[i][j].getStatus().equals("M"))
                    count++;
        }
        return count;
    }

    /**
     * gameOver
     * 
     * Ways a game of Minesweeper ends:
     * 1. player guesses a cell with a mine: game over -> player loses
     * 2. player has revealed the last cell without revealing any mines -> player wins
     * 
     * @return boolean Return false if game is not over and squares have yet to be revealed, otheriwse return true.
     */
    public boolean gameOver() {
        return gameOver;
    }

    /**
     * Reveal the cells that contain zeroes that surround the inputted cell.
     * Continue revealing 0-cells in every direction until no more 0-cells are found in any direction.
     * Utilize a STACK to accomplish this.
     *
     * This method should follow the psuedocode given in the lab writeup.
     * Why might a stack be useful here rather than a queue?
     *
     * @param x      The x value the user entered.
     * @param y      The y value the user entered.
     */
    public void revealZeroes(int x, int y) {
        Stack1Gen<int[]> myStack = new Stack1Gen<>();
        myStack.push(new int[] {x, y});

        int[] temp;
        int row;
        int col;
        while (!(myStack.isEmpty())) {
            temp = myStack.pop();
            row = temp[0];
            col = temp[1];
            minefield[row][col].setRevealed(true);

            // Check and push neighbors if they are zeros
            for (int i = Math.max(0, row - 1); i <= Math.min(minefield.length - 1, row + 1); i++)
                for (int j = Math.max(0, col - 1); j <= Math.min(minefield[0].length - 1, col + 1); j++) {
                    if (!(minefield[i][j].getRevealed()) && minefield[i][j].getStatus().equals("0"))
                        myStack.push(new int[] {i, j});
            }
        }
    }












    /**
     * revealStartingArea
     *
     * On the starting move only reveal the neighboring cells of the inital cell and continue revealing the surrounding concealed cells until a mine is found.
     * Utilize a QUEUE to accomplish this.
     * 
     * This method should follow the psuedocode given in the lab writeup.
     * Why might a queue be useful for this function?
     *
     * @param x     The x value the user entered.
     * @param y     The y value the user entered.
     */
    public void revealStartingArea(int x, int y) {
        QGen<int[]> myQ = new Q1Gen<>();
        myQ.add(new int[] {x, y});

        int[] temp;
        int row;
        int col;
        while (myQ.length() > 0) {
            temp = myQ.remove();
            row = temp[0];
            col = temp[1];

            if (minefield[row][col].getStatus().equals("M"))
                break;

            for (int i = Math.max(0, row - 1); i <= Math.min(minefield.length - 1, row + 1); i++) {
                for (int j = Math.max(0, col - 1); j <= Math.min(minefield[0].length - 1, col + 1); j++)
                    if (!(minefield[i][j].getRevealed()) && minefield[i][j].getStatus().equals("0"))
                        myQ.add(new int[] {i, j});
            }

        }
    }

    /**
     * For both printing methods utilize the ANSI colour codes provided! 
     * 
     * 
     * 
     * 
     * 
     * debug
     *
     * @function This method should print the entire minefield, regardless if the user has guessed a square.
     * *This method should print out when debug mode has been selected. 
     */
    public void debug() {
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j++) {
                System.out.print(minefield[i][j].getStatus() + " ");
            }
            System.out.println();
        }
    }


    /**
     * toString
     *
     * @return String The string that is returned only has the squares that has been revealed to the user or that the user has guessed.
     */
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for (int i = 0; i < minefield[0].length; i++) {
            out.append(" ").append(i).append(" ");
        }
        out.append('\n');

        Cell cell;
        for (int i = 0; i < minefield.length; i++) {
            out.append(i).append(" ");
            for (int j = 0; j < minefield[0].length; j++) {
                cell = minefield[i][j];

                if (!(cell.getRevealed())) {
                    out.append(ANSI_GREY_BACKGROUND).append(" - ");
                } else if (cell.getStatus().equals(" F ")) {
                    out.append(ANSI_RED).append(" F ");
                } else if (cell.getStatus().equals(" M ")) {
                    out.append(ANSI_PURPLE_BACKGROUND).append(" M ");
                } else {
                    String colorCode;
                    switch (cell.getStatus()) {
                        case "1":
                            colorCode = ANSI_BLUE;
                            break;
                        case "2":
                            colorCode = ANSI_GREEN;
                            break;
                        case "3":
                            colorCode = ANSI_RED;
                            break;
                        case "4":
                            colorCode = ANSI_WHITE_BACKGROUND;
                            break;
                        case "5":
                            colorCode = ANSI_PURPLE;
                            break;
                        case "6":
                            colorCode = ANSI_BLUE_BRIGHT;
                            break;
                        case "7":
                            colorCode = ANSI_CYAN;
                            break;
                        case "8":
                            colorCode = ANSI_YELLOW_BRIGHT;
                            break;

                        default: colorCode = ANSI_YELLOW;
                    }
                    out.append(colorCode).append(cell.getStatus()).append(ANSI_GREY_BACKGROUND).append("|");
                }
            }
            out.append("\n");
        }
        return out.toString();
    }
    private Cell[][] minefield;
    private int numMines;
    private int numFlags;
    private boolean gameOver = false;
}
