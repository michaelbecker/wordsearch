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

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
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

}
