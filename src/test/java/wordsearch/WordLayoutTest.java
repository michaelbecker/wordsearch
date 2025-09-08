package wordsearch;

import org.junit.jupiter.api.*;


/**
 * Unit test for WordLayout class.
 */
public class WordLayoutTest 
{
    @Test
    public void testValidLayout() {
        WordLayout layout = new WordLayout(25, 25, 25, 25);
        Assertions.assertNotNull(layout);
    }

    @Test
    public void testInvalidLayout() {
        try {
            WordLayout layout = new WordLayout(30, 30, 30, 11);
            System.out.println(layout.toString());
            Assertions.fail("Expected IllegalArgumentException for invalid layout percentages");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}
