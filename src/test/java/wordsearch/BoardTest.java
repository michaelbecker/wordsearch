package wordsearch;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Board class.
 */
public class BoardTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BoardTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BoardTest.class );
    }

    
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

    public void testInitialization() {
        int rows = 5;
        int cols = 5;
        Board b = new Board(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertEquals(b.getChar(i, j), ' ');
            }
        }
    }

    public void testGetRow() {
        Board b = prefillBoard();
        char[] expectedRow0 = {'0', '1', '2'};
        char[] expectedRow1 = {'3', '4', '5'};
        char[] expectedRow2 = {'6', '7', '8'};
        assertTrue(java.util.Arrays.equals(b.getRow(0), expectedRow0));
        assertTrue(java.util.Arrays.equals(b.getRow(1), expectedRow1));
        assertTrue(java.util.Arrays.equals(b.getRow(2), expectedRow2));
    }

    public void testGetCol() {
        Board b = prefillBoard();
        char[] expectedCol0 = {'0', '3', '6'};
        char[] expectedCol1 = {'1', '4', '7'};
        char[] expectedCol2 = {'2', '5', '8'};
        assertTrue(java.util.Arrays.equals(b.getCol(0), expectedCol0));
        assertTrue(java.util.Arrays.equals(b.getCol(1), expectedCol1));
        assertTrue(java.util.Arrays.equals(b.getCol(2), expectedCol2));
    }

    public void testGetChar() {
        Board b = prefillBoard();
        assertEquals(b.getChar(0, 0), '0');
        assertEquals(b.getChar(1, 1), '4');
        assertEquals(b.getChar(2, 2), '8');
    }
}
