package wordsearch;

import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class WordSearchTest
{
    @Test
    public void testWordSearch1() {
        String [] words = {"cat", "dog", "fish"};
        WordLayout wordLayout = new WordLayout(25, 25, 25, 25);
        WordList wordList = new WordList(words);
        WordSearch ws = new WordSearch(10, 10, wordList, wordLayout);
        ws.toString();
    }


    @Test
    public void testWordSearch2() {
        String [] words = {"cat", "dog", "fish"};
        WordLayout wordLayout = new WordLayout(25, 25, 25, 25);
        WordList wordList = new WordList(words);
        WordSearch ws = new WordSearch(4, 4, wordList, wordLayout);
        ws.toString();
    }


    @Test
    public void testWordSearch3() {
        String [] words = {"cat", "dog", "fish"};
        WordLayout wordLayout = new WordLayout(25, 25, 25, 25);
        WordList wordList = new WordList(words);
        WordSearch ws = new WordSearch(3, 3, wordList, wordLayout);
        ws.toString();
    }
}
