public class ScoreBoard {

    private GameEntry[] board;
    private int numEntries = 0;

    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry g) {
        int newScore = g.getScore();
        String name = g.getName();
        if (numEntries < board.length || newScore > board[numEntries -  1].getScore()) {
            if (numEntries < board.length) {
                numEntries += 1;
            }

            // Shift any lower scores rightward to make room for the new entry.
            int j = numEntries - 1;
            while (j > 0 && (board[j - 1].getScore() < newScore)) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = g;
        } else {
            System.out.println("The list is already full and score doest qualify to" +
                    " be in the list");
        }
    }

    // removes the ith index of the array.
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (i >= numEntries) || (board[i] != null)) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry temp = board[i];
        for (int j = i; j < (numEntries - 1); j++) {
            board[i] = board[i + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }


}
