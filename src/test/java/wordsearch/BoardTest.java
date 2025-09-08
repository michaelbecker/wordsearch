package wordsearch;

import org.junit.jupiter.api.*;

/**
 * Unit test for Board class.
 */
public class BoardTest
{
    
    private Board prefillBoard() {
        int rows = 3;
        int cols = 3;
        Board b = new Board(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int num = '0' + (i * cols + j); // ASCII value for 'A' is 65
                b.addChar(i, j, (char)num);
            }
        }
        return b;
    }

    @Test
    public void testInitialization1() {
        int rows = 5;
        int cols = 5;
        Board b = new Board(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Assertions.assertEquals(b.getChar(i, j), ' ');
            }
        }
    }


    public void testInitialization2() {
        int rows = 10;
        int cols = 15;
        Board b = new Board(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Assertions.assertEquals(b.getChar(i, j), ' ');
            }
        }
    }

    public void testInitialization3() {
        int rows = 15;
        int cols = 10;
        Board b = new Board(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Assertions.assertEquals(b.getChar(i, j), ' ');
            }
        }
    }

    public void testInitialization4(){
        int rows = 1;
        int cols = 1;
        Board b = new Board(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Assertions.assertEquals(b.getChar(i, j), ' ');
            }
        }
    }

    public void testGetRow() {
        Board b = prefillBoard();
        char[] expectedRow0 = {'0', '1', '2'};
        char[] expectedRow1 = {'3', '4', '5'};
        char[] expectedRow2 = {'6', '7', '8'};
        Assertions.assertTrue(java.util.Arrays.equals(b.getRow(0), expectedRow0));
        Assertions.assertTrue(java.util.Arrays.equals(b.getRow(1), expectedRow1));
        Assertions.assertTrue(java.util.Arrays.equals(b.getRow(2), expectedRow2));
    }

    public void testGetCol() {
        Board b = prefillBoard();
        char[] expectedCol0 = {'0', '3', '6'};
        char[] expectedCol1 = {'1', '4', '7'};
        char[] expectedCol2 = {'2', '5', '8'};
        Assertions.assertTrue(java.util.Arrays.equals(b.getCol(0), expectedCol0));
        Assertions.assertTrue(java.util.Arrays.equals(b.getCol(1), expectedCol1));
        Assertions.assertTrue(java.util.Arrays.equals(b.getCol(2), expectedCol2));
    }

    public void testGetChar() {
        Board b = prefillBoard();
        Assertions.assertEquals(b.getChar(0, 0), '0');
        Assertions.assertEquals(b.getChar(1, 1), '4');
        Assertions.assertEquals(b.getChar(2, 2), '8');
    }
}
