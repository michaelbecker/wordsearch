package wordsearch;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class RandomLetterGeneratorTest extends TestCase
{
    public RandomLetterGeneratorTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( RandomLetterGeneratorTest.class );
    }

    public void testGenerateRandomLetter() {
        LetterFrequency lf = new LetterFrequency();
        RandomLetterGenerator rlg = new RandomLetterGenerator(lf);
        for (int i = 0; i < 1000; i++) {
            char c = rlg.generateRandomLetter();
            assertTrue(c >= 'A' && c <= 'Z');
        }
    }

}
