package wordsearch;

import java.util.Arrays;
import java.util.Iterator;


public class WordList implements Iterable<String> {

    public WordList(String[] word_list ) {

        int i = 0;
        wordListRaw = new String[word_list.length];

        for (String w : word_list) {
            wordListRaw[i++] = w.toUpperCase();
        }

        wordListBySize = Arrays.copyOf(wordListRaw, wordListRaw.length);
        wordListBySizeReversed = Arrays.copyOf(wordListRaw, wordListRaw.length);

        Arrays.sort(wordListBySize, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Arrays.sort(wordListBySizeReversed, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
    }


    public WordList setIterateByRaw() {
        iterateByRaw = true;
        iterateBySize = false;
        iterateBySizeReversed = false;
        return this;
    }


    public WordList setIterateBySize() {
        iterateByRaw = false;
        iterateBySize = true;
        iterateBySizeReversed = false;
        return this;
    }


    public WordList setIterateBySizeReversed() {
        iterateByRaw = false;
        iterateBySize = false;
        iterateBySizeReversed = true;
        return this;
    }


    private String[] getStringList() {
        if (iterateByRaw)
            return wordListRaw;
        else if (iterateBySize)
            return wordListBySize;
        else
            return wordListBySizeReversed;
    }


    @Override
    public Iterator<String> iterator() {

        String [] list = getStringList();
        return Arrays.asList(list).iterator();
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String [] list = getStringList();
        
        for (String word : list) {
            sb.append(word).append("\n");
        }

        return sb.toString();
    }


    private String[] wordListRaw;
    private String[] wordListBySize;
    private String[] wordListBySizeReversed;

    private boolean iterateByRaw = true;
    private boolean iterateBySize = false;
    private boolean iterateBySizeReversed = false;


    public static void main(String[] argv) {

        String[] list = {"1-Apple", "2-Cat", "3-Dog", "4-Banana"};

        WordList wordList = new WordList(list);

        System.out.println(wordList.setIterateByRaw().toString());
        System.out.println(wordList.setIterateBySize().toString());
        System.out.println(wordList.setIterateBySizeReversed().toString());

        wordList.setIterateByRaw();
        for (var w: wordList) {
            System.out.println(w);
        }
        System.out.println("\n");

        wordList.setIterateBySize();
        for (var w: wordList) {
            System.out.println(w);
        }
        System.out.println("\n");

        wordList.setIterateBySizeReversed();
        for (var w: wordList) {
            System.out.println(w);
        }
        System.out.println("\n");
    }

}
