package wordsearch;

import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class WordSearchTest
{
    @Test
    public void testWordSearch() {
        String [] words = {"cat", "dog", "fish"};
        WordLayout wordLayout = new WordLayout(25, 25, 25, 25);
        WordList wordList = new WordList(words);
        WordSearch ws = new WordSearch(10, 10, wordList, wordLayout);
    }
}
