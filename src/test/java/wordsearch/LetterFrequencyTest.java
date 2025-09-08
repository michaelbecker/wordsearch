package wordsearch;

import org.junit.jupiter.api.*;


/**
 * Unit test for LetterFrequency class.
 */
public class LetterFrequencyTest
{
    @Test
    public void testGetFrequency() {
        LetterFrequency lf = new LetterFrequency();
        Assertions.assertEquals(8.167, lf.getFrequency('A'));
        Assertions.assertEquals(1.492, lf.getFrequency('B'));
        Assertions.assertEquals(2.782, lf.getFrequency('C'));
        Assertions.assertEquals(4.025, lf.getFrequency('D'));
        Assertions.assertEquals(12.702, lf.getFrequency('E'));
        Assertions.assertEquals(2.228, lf.getFrequency('F'));
        Assertions.assertEquals(2.015, lf.getFrequency('G'));
        Assertions.assertEquals(6.094, lf.getFrequency('H'));
        Assertions.assertEquals(6.966, lf.getFrequency('I'));
        Assertions.assertEquals(0.153, lf.getFrequency('J'));
        Assertions.assertEquals(0.772, lf.getFrequency('K'));
        Assertions.assertEquals(4.025, lf.getFrequency('L'));
        Assertions.assertEquals(2.406, lf.getFrequency('M'));
        Assertions.assertEquals(6.749, lf.getFrequency('N'));
        Assertions.assertEquals(7.507, lf.getFrequency('O'));
        Assertions.assertEquals(1.929, lf.getFrequency('P'));
        Assertions.assertEquals(0.095, lf.getFrequency('Q'));
        Assertions.assertEquals(5.987, lf.getFrequency('R'));
        Assertions.assertEquals(6.327, lf.getFrequency('S'));
        Assertions.assertEquals(9.056, lf.getFrequency('T'));
        Assertions.assertEquals(2.758, lf.getFrequency('U'));
        Assertions.assertEquals(0.978, lf.getFrequency('V'));
        Assertions.assertEquals(2.360, lf.getFrequency('W'));
        Assertions.assertEquals(0.150, lf.getFrequency('X'));
        Assertions.assertEquals(1.974, lf.getFrequency('Y'));
        Assertions.assertEquals(0.074, lf.getFrequency('Z'));
    }

    @Test
    public void testGetFrequencyInvalid() {
        LetterFrequency lf = new LetterFrequency();
        try     {
            lf.getFrequency('1');
            Assertions.fail("Expected IllegalArgumentException for non-letter input");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }   catch (Exception e) {
            Assertions.fail("Expected IllegalArgumentException, but got " + e.getClass().getSimpleName());
        }
    }
    
}
