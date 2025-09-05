package wordsearch;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for WordLayout class.
 */
public class WordLayoutTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WordLayoutTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WordLayoutTest.class );
    }


    public void testValidLayout() {
        WordLayout layout = new WordLayout(25, 25, 25, 25);
        assertNotNull(layout);
    }

    public void testInvalidLayout() {
        try {
            WordLayout layout = new WordLayout(30, 30, 30, 11);
            System.out.println(layout.toString());
            fail("Expected IllegalArgumentException for invalid layout percentages");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}
