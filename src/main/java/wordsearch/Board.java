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

    public void placeWord(String word, Direction direction) {

        Random random = new Random();
        int length = word.length();

        switch (direction) {
            case HORIZONTAL:
                break;
            case VERTICAL:
                break;
            case DIAGONAL_DOWN:
                break;
            case DIAGONAL_UP:
                break;

            default:
                break;
        }
    }

    private char[][] board;
    private final int NUM_ROWS;
    private final int NUM_COLS;
}
