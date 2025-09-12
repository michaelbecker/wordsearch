package wordsearch;

import java.util.Arrays;
import java.util.Random;

public class Board {


    public Board(int rows, int cols) {
        this.NUM_ROWS = rows;
        this.NUM_COLS = cols;
        board = new char[rows][cols];
        initialize();
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
        for (char[] row : board) {
            sb.append(new String(row)).append("\n");
        }
        return sb.toString();
    }


    public void initialize() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                board[i][j] = ' ';
            }
        }
    }


    private boolean isBlank(int start_row, int start_col,
                            int end_row, int end_col, int length) {
        int i = 0;
        int row = start_row;
        int col = start_col;

        for (i = 0; i < length; i++) {

            if (board[row][col] != ' ')
                return false;

            if (start_row < end_row)
                row++;
            else if (start_row > end_row)
                row--;

            if (start_col < end_col)
                col++;
            else if (start_col > end_col)
                col--;
        }

        return true;
    }


    private void placeWord(int start_row, int start_col,
                           int end_row, int end_col,
                           String word) {

        int i = 0;
        int row = start_row;
        int col = start_col;

        for (i = 0; i < word.length(); i++) {

            board[row][col] = word.charAt(i);

            if (start_row < end_row)
                row++;
            else if (start_row > end_row)
                row--;

            if (start_col < end_col)
                col++;
            else if (start_col > end_col)
                col--;
        }
    }


    public void placeWord(String word, Direction direction) {

        Random random = new Random();
        int length = word.length();
        int row;
        int col;

        switch (direction) {
            case HORIZONTAL:
                do {
                    row = random.nextInt(NUM_ROWS);
                    col = random.nextInt(NUM_COLS - length);
                } while (!isBlank(row, col, row, col + length, length));

                placeWord(row, col, row, col + length , word);

                break;

            case VERTICAL:
                do {
                    row = random.nextInt(NUM_ROWS - length);
                    col = random.nextInt(NUM_COLS);
                } while (!isBlank(row, col, row + length, col, length));

                placeWord(row, col, row + length, col, word);

                break;

            case DIAGONAL_DOWN:
                do {
                    row = random.nextInt(NUM_ROWS - length);
                    col = random.nextInt(NUM_COLS - length);
                } while (!isBlank(row, col, row + length, col + length, length));

                placeWord(row, col, row + length, col + length, word);

                break;

            case DIAGONAL_UP:
                do {
                    row = random.nextInt(NUM_ROWS - length);
                    col = random.nextInt(NUM_COLS - length);
                } while (!isBlank(row, col, row + length, col + length, length));

                placeWord(row + length, col, row, col + length, word);

                break;

            default:
                break;
        }
    }


    private char[][] board;
    private final int NUM_ROWS;
    private final int NUM_COLS;


    public static void main(String[] argv) 
    {
        boolean success;
        int rows = 3;
        int cols = 4;
        Board b = new Board(rows, cols);
        success = b.isBlank(0, 0, 3, 0, 3);
        success = b.isBlank(0, 0, 0, 4, 3);
        success = b.isBlank(0, 0, 3, 4, 4);
    }


}
