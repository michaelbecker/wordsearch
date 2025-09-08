package wordsearch;

import org.junit.jupiter.api.*;


public class RandomLetterGeneratorTest
{
    @Test
    public void testGenerateRandomLetter() {
        LetterFrequency lf = new LetterFrequency();
        RandomLetterGenerator rlg = new RandomLetterGenerator(lf);
        for (int i = 0; i < 1000; i++) {
            char c = rlg.generateRandomLetter();
            Assertions.assertTrue(c >= 'A' && c <= 'Z');
        }
    }

}
