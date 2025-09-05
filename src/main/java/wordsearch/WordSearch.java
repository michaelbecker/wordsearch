package wordsearch;

/**
 * Hello world!
 *
 */
public class WordSearch
{
    public static void main( String[] args )
    {
        System.out.println( "WordSearch Hello World!" );
        Board board = new Board(3, 3);
        System.out.println(board.toString()); 
    }
}
