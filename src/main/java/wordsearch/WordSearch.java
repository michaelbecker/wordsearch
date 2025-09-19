package wordsearch;



public class WordSearch
{
    public static void main( String[] args )
    {
        String [] words = {"cat", "dog", "fish"};
        WordLayout wordLayout = new WordLayout(25, 25, 25, 25);
        WordList wordList = new WordList(words);
        WordSearch ws = new WordSearch(10, 10, wordList, wordLayout);
    }


    public WordSearch(  int rows, int cols,
                        WordList wordList,
                        WordLayout wordLayout) {

        this.wordList = wordList;
        this.wordLayout = wordLayout;

        board = new Board(rows, cols);
        letterFrequency = new LetterFrequency();
        randomLetterGenerator = new RandomLetterGenerator(letterFrequency);
        generateWordSearch();
    }


    private void generateWordSearch() {

        wordList.setIterateBySizeReversed();
        
        // TODO -- Need to recursivey fit this, with backtracking...
        for (String word : wordList) {
            Direction direction = wordLayout.getRandomDirection();
            boolean success = board.placeWord(word, direction);
        }
        
        board.fillEmptySpaces(randomLetterGenerator);

        System.out.println(board.toString());
    }


    @Override
    public String toString() {
        return board.toString();
    }


    private Board board;
    private WordList wordList;
    private LetterFrequency letterFrequency;
    private RandomLetterGenerator randomLetterGenerator;
    private WordLayout wordLayout;

}
