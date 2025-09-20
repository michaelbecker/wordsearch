package wordsearch;



public class WordSearch
{
    public static void main( String[] args )
    {
        String [] words = { "cat", 
                            "dog", 
                            "fish", 
                            "meteorbob",
                            "Bert",
                            "Raisin",
                            "bubble"
                            };
        WordLayout wordLayout = new WordLayout(40, 40, 10, 10);
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


    private Board generateWordSearchRecursive(WordList list, Board intialBoard) {

        String head = list.getWordListHead();
        WordList tail = list.getWordListTail();
        int fitCount = 0;
        final int MAX_NUM_FIT_ATTEMPTS = 10000;

        System.out.println(intialBoard.toString());

        do {
            Board board = new Board(intialBoard);        
            Direction direction = wordLayout.getRandomDirection();
            boolean success = board.placeWord(head, direction);
            
            if (success) {
                if (tail == null) {
                    return board;
                }
                else {
                    Board b = generateWordSearchRecursive(tail, board);
                    if (success) {
                        return b;
                    }
                    else {
                        fitCount++;
                    }
                }
            }
            else {
                return null;
            }

        } while(fitCount < MAX_NUM_FIT_ATTEMPTS);

        return null;
    }


    private boolean generateWordSearch() {

        wordList.setIterateBySizeReversed();
        
        Board b = generateWordSearchRecursive(wordList, board);

        if (b == null) {
            return false;
        }
        else {
            board = b;
        }

        // TODO -- Need to recursivey fit this, with backtracking...
        //for (String word : wordList) {
        //    Direction direction = wordLayout.getRandomDirection();
        //    boolean success = board.placeWord(word, direction);
        //}
        
        board.fillEmptySpaces(randomLetterGenerator);
        System.out.println(board.toString());
        return true;
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
