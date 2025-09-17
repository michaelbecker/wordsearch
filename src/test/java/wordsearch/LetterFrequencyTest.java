package wordsearch;

import org.junit.jupiter.api.*;


/**
 * Unit test for LetterFrequency class.
 */
public class LetterFrequencyTest
{
    @Test
    public void testGetFrequency() {

        LetterFrequency letterFrequency = new LetterFrequency();
        double sum = 0;

        for (int i = 0; i < 26; i++) {
            char letter = (char)('A' + i);
            double freq = letterFrequency.getFrequency(letter);
            sum += freq;
        }

        double diff = sum - 100.0;

        Assertions.assertTrue(diff < LetterFrequency.EPSILON);
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
