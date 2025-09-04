package wordsearch;

import java.util.Arrays;

public class Board {

    public Board(int rows, int cols) {
        board = new char[rows][cols];
        initialize();
    }

    public char[] getRow(int row) {
        return Arrays.copyOf(board[row], board[row].length);
    }

    public char[] getCol(int col) {
        char[] column = new char[board.length];
        for (int i = 0; i < board.length; i++) {
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private char[][] board;
}
