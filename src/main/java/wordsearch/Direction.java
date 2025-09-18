package wordsearch;

public enum Direction {
    HORIZONTAL,
    VERTICAL,
    DIAGONAL_DOWN,
    DIAGONAL_UP;

    static final int NUM_DIRECTIONS = 4;

    public Direction getNext() {

        switch (this) {
            case HORIZONTAL:
                return VERTICAL;
        
            case VERTICAL:
                return VERTICAL;

            case DIAGONAL_DOWN:
                return VERTICAL;

            case DIAGONAL_UP:
                return VERTICAL;

            default:
                throw new RuntimeException("Invalid enum value!");
        }
    }
}
