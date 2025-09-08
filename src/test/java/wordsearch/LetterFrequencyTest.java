package wordsearch;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for LetterFrequency class.
 */
public class LetterFrequencyTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LetterFrequencyTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LetterFrequencyTest.class );
    }


    public void testGetFrequency() {
        LetterFrequency lf = new LetterFrequency();
        assertEquals(8.167, lf.getFrequency('A'));
        assertEquals(1.492, lf.getFrequency('B'));
        assertEquals(2.782, lf.getFrequency('C'));
        assertEquals(4.025, lf.getFrequency('D'));
        assertEquals(12.702, lf.getFrequency('E'));
        assertEquals(2.228, lf.getFrequency('F'));
        assertEquals(2.015, lf.getFrequency('G'));
        assertEquals(6.094, lf.getFrequency('H'));
        assertEquals(6.966, lf.getFrequency('I'));
        assertEquals(0.153, lf.getFrequency('J'));
        assertEquals(0.772, lf.getFrequency('K'));
        assertEquals(4.025, lf.getFrequency('L'));
        assertEquals(2.406, lf.getFrequency('M'));
        assertEquals(6.749, lf.getFrequency('N'));
        assertEquals(7.507, lf.getFrequency('O'));
        assertEquals(1.929, lf.getFrequency('P'));
        assertEquals(0.095, lf.getFrequency('Q'));
        assertEquals(5.987, lf.getFrequency('R'));
        assertEquals(6.327, lf.getFrequency('S'));
        assertEquals(9.056, lf.getFrequency('T'));
        assertEquals(2.758, lf.getFrequency('U'));
        assertEquals(0.978, lf.getFrequency('V'));
        assertEquals(2.360, lf.getFrequency('W'));
        assertEquals(0.150, lf.getFrequency('X'));
        assertEquals(1.974, lf.getFrequency('Y'));
        assertEquals(0.074, lf.getFrequency('Z'));
    }


    public void testGetFrequencyInvalid() {
        LetterFrequency lf = new LetterFrequency();
        try     {
            lf.getFrequency('1');
            fail("Expected IllegalArgumentException for non-letter input");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }   catch (Exception e) {
            fail("Expected IllegalArgumentException, but got " + e.getClass().getSimpleName());
        }
    }
    
}
