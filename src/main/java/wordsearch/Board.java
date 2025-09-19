package wordsearch;

import java.util.Arrays;


public class Board {


    public Board(int rows, int cols) {
        this.NUM_ROWS = rows;
        this.NUM_COLS = cols;
        board = new char[rows][cols];
        initialize();
    }


    public Board(Board old) {
        NUM_ROWS = old.NUM_ROWS;
        NUM_COLS = old.NUM_COLS;

        board = new char[old.board.length][];
        for (int i = 0; i < old.board.length; i++) {
            board[i] = new char[old.board[i].length];
            for (int j = 0; j < old.board[i].length; j++)
                board[i][j] = old.board[i][j];
        }
    }


    public char[] getRow(int row) {
        return Arrays.copyOf(board[row], NUM_COLS);
    }


    public char[] getCol(int col) {
        char[] column = new char[NUM_ROWS];
        for (int i = 0; i < NUM_ROWS; i++) {
            column[i] = board[i][col];
        }
        return column;
    }


    public char getChar(int row, int col) {
        return board[row][col];
    }


    public void addChar(int row, int col, char c) {
        board[row][col] = c;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("+");
        for (int i = 0; i < NUM_COLS; i++)
            sb.append("-");
        sb.append("+\n");

        for (char[] row : board) {
            sb.append("|");
            sb.append(new String(row));
            sb.append("|\n");
        }

        sb.append("+");
        for (int i = 0; i < NUM_COLS; i++)
            sb.append("-");
        sb.append("+\n");

        return sb.toString();
    }


    public void initialize() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                board[i][j] = ' ';
            }
        }
    }


    private boolean isBlank(int start_row,
                            int start_col,
                            Direction direction,
                            int length) {

        int row = start_row;
        int col = start_col;

        switch (direction) {
            case HORIZONTAL:
                for (int i = 0; i < length; i++, col++) {
                    if (board[row][col] != ' ')
                        return false;
                }
                return true;

            case VERTICAL:
                for (int i = 0; i < length; i++, row++) {
                    if (board[row][col] != ' ')
                        return false;
                }
                return true;

            case DIAGONAL_DOWN:
                for (int i = 0; i < length; i++, row++, col++) {
                    if (board[row][col] != ' ')
                        return false;
                }
                return true;

            case DIAGONAL_UP:
                for (int i = 0; i < length; i++, row--, col++) {
                    if (board[row][col] != ' ')
                        return false;
                }
                return true;

            default:
                return false;
        }
    }


    private boolean willFit( int start_row,
                            int start_col,
                            Direction direction,
                            String word) {


        int row = start_row;
        int col = start_col;
        int length = word.length();

        switch (direction) {
            case HORIZONTAL:
                for (int i = 0; i < length; i++, col++) {
                    if ((board[row][col] != ' ') && (board[row][col] != word.charAt(i))) {
                        return false;
                    }
                }
                break;

            case VERTICAL:
                for (int i = 0; i < length; i++, row++) {
                    if ((board[row][col] != ' ') && (board[row][col] != word.charAt(i))) {
                        return false;
                    }
                }
                break;

            case DIAGONAL_DOWN:
                for (int i = 0; i < length; i++, row++, col++) {
                    if ((board[row][col] != ' ') && (board[row][col] != word.charAt(i))) {
                        return false;
                    }
                }
                break;

            case DIAGONAL_UP:
                for (int i = 0; i < length; i++, row--, col++) {
                    if ((board[row][col] != ' ') && (board[row][col] != word.charAt(i))) {
                        return false;
                    }
                }
                break;
        }

        return true;
    }


    private void writeWordToBoard( int start_row,
                            int start_col,
                            Direction direction,
                            String word) {


        int row = start_row;
        int col = start_col;
        int length = word.length();

        switch (direction) {
            case HORIZONTAL:
                for (int i = 0; i < length; i++, col++) {
                    board[row][col] = word.charAt(i);
                }
                break;

            case VERTICAL:
                for (int i = 0; i < length; i++, row++) {
                    board[row][col] = word.charAt(i);
                }
                break;

            case DIAGONAL_DOWN:
                for (int i = 0; i < length; i++, row++, col++) {
                    board[row][col] = word.charAt(i);
                }
                break;

            case DIAGONAL_UP:
                for (int i = 0; i < length; i++, row--, col++) {
                    board[row][col] = word.charAt(i);
                }
                break;
        }
    }


    public boolean placeWord(String word, Direction direction) {

        SafeRandom random = new SafeRandom();
        int length = word.length();
        int row = 0;
        int col = 0;
        int fitCount = 0;
        final int MAX_COUNT = 100000;
        int directionCount;

        FIT_LOOP:
        for (directionCount = 0; directionCount < Direction.NUM_DIRECTIONS; directionCount++) {

            switch (direction) {

                case HORIZONTAL:
                    do {
                        row = random.nextIntSafe(NUM_ROWS);
                        col = random.nextIntSafe(NUM_COLS - length + 1);
                        if (fitCount++ > MAX_COUNT) {
                            direction = direction.getNext();
                            fitCount = 0;
                            break;
                        }
                    } while (!willFit(row, col, Direction.HORIZONTAL, word));
                    break FIT_LOOP;

                case VERTICAL:
                    do {
                        row = random.nextIntSafe(NUM_ROWS - length + 1);
                        col = random.nextIntSafe(NUM_COLS);
                        if (fitCount++ > MAX_COUNT) {
                            direction = direction.getNext();
                            fitCount = 0;
                            break;
                        }
                    } while (!willFit(row, col, Direction.VERTICAL, word));
                    break FIT_LOOP;

                case DIAGONAL_DOWN:
                    do {
                        row = random.nextIntSafe(NUM_ROWS - length + 1);
                        col = random.nextIntSafe(NUM_COLS - length + 1);
                        if (fitCount++ > MAX_COUNT) {
                            direction = direction.getNext();
                            fitCount = 0;
                            break;
                        }
                    } while (!willFit(row, col, Direction.DIAGONAL_DOWN, word));
                    break FIT_LOOP;

                case DIAGONAL_UP:
                    do {
                        row = random.nextIntSafe(NUM_ROWS - length) + length - 1;
                        col = random.nextIntSafe(NUM_COLS - length);
                        if (fitCount++ > MAX_COUNT) {
                            direction = direction.getNext();
                            fitCount = 0;
                            break;
                        }
                    } while (!willFit(row, col, Direction.DIAGONAL_UP, word));
                    break FIT_LOOP;
            }
        }

        if (directionCount < Direction.NUM_DIRECTIONS) {
            writeWordToBoard(row, col, direction, word);
            return true;
        }
        else {
            System.out.println("Unfitable word: " + word);
            System.out.println("direction: " + direction.toString());
            System.out.println(toString());
            return false;
        }
    }


    public void fillEmptySpaces(RandomLetterGenerator randomLetterGenerator) {

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = randomLetterGenerator.generateRandomLetter();
                }
            }
        }
    }


    private char[][] board;
    private final int NUM_ROWS;
    private final int NUM_COLS;


    public static void main(String[] argv)
    {
        debugTest1();
    }


    private static void debugTest1()
    {
        boolean success;
        int rows = 3;
        int cols = 4;
        Board b = new Board(rows, cols);

        b.initialize();
        b.placeWord("fish", Direction.HORIZONTAL);
        b.placeWord("dogs", Direction.HORIZONTAL);
        b.placeWord("cats", Direction.HORIZONTAL);
        System.out.println(b.toString());

        Board copy_b = new Board(b);
        System.out.println(copy_b.toString());

        b.initialize();
        b.placeWord("cat", Direction.VERTICAL);
        b.placeWord("dog", Direction.VERTICAL);
        b.placeWord("ant", Direction.VERTICAL);
        b.placeWord("123", Direction.VERTICAL);
        System.out.println(b.toString());

        b.initialize();
        b.placeWord("cat", Direction.DIAGONAL_DOWN);
        b.placeWord("bat", Direction.DIAGONAL_UP);
        b.placeWord("cob", Direction.VERTICAL);
        b.placeWord("tot", Direction.VERTICAL);
        System.out.println(b.toString());

        b.initialize();
        b.placeWord("cat", Direction.DIAGONAL_UP);
        System.out.println(b.toString());

        b.initialize();
        b.placeWord("fsh", Direction.HORIZONTAL);
        b.placeWord("dog", Direction.HORIZONTAL);
        b.placeWord("cat", Direction.HORIZONTAL);
        System.out.println(b.toString());


        rows = 4;
        cols = 3;
        b = new Board(rows, cols);

        System.out.println(b.toString());

        success = b.isBlank(0, 0, Direction.HORIZONTAL, 3);
        System.out.println("success = " + success);

        success = b.isBlank(0, 0, Direction.VERTICAL, 4);
        System.out.println("success = " + success);

        success = b.isBlank(0, 0, Direction.DIAGONAL_DOWN, 3);
        System.out.println("success = " + success);

        success = b.isBlank(rows - 1, 0, Direction.DIAGONAL_UP, 3);
        System.out.println("success = " + success);
    }
}
