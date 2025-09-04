package wordsearch;

import java.util.Arrays;

public class Board {

    public Board(int rows, int cols) {
        board = new char[rows][cols];
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            sb.append(new String(row)).append("\n");
        }
        return sb.toString();
    }

    public void prefillWithNumbers() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = (char) ('0' + (i * board[i].length + j) % 10);
            }
        }
    }

    private char[][] board;
}
