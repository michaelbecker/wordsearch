package wordsearch;



public class WordSearch
{
    public static void main( String[] args )
    {
        System.out.println( "WordSearch Hello World!" );
        Board board = new Board(3, 3);
        System.out.println(board.toString());
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
        for (String word : wordList) {
            board.placeWord(word, wordLayout.getRandomDirection());
        }
        //board.fillEmptySpaces(randomLetterGenerator);
        System.out.println(board.toString());
    }


    private Board board;
    private WordList wordList;
    private LetterFrequency letterFrequency;
    private RandomLetterGenerator randomLetterGenerator;
    private WordLayout wordLayout;

}
