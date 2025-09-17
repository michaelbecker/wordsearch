package wordsearch;

import java.util.Arrays;
import java.util.Iterator;


public class WordList implements Iterable<String> {

    public WordList(String[] words ) {

        int i = 0;
        this.words = new String[words.length];

        for (String word : words) {
            this.words[i++] = word.toUpperCase();
        }
    }


    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(words).iterator();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        return sb.toString();
    }


    private String[] words;
}
