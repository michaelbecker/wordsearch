package wordsearch;

import java.util.Random;


public record WordLayout(   int horizontalPercent,
                            int verticalPercent,
                            int downDiagonalPercent,
                            int upDiagonalPercent)
{
    public WordLayout {
        int total = horizontalPercent + verticalPercent + downDiagonalPercent + upDiagonalPercent;
        if (total != 100) {
            throw new IllegalArgumentException("The sum of all percentages must equal 100.");
        }
    }

    public Direction getRandomDirection() {
        Random random = new Random();
        int rand = random.nextInt(100);
        if (rand < horizontalPercent) {
            return Direction.HORIZONTAL;
        } else if (rand < horizontalPercent + verticalPercent) {
            return Direction.VERTICAL;
        } else if (rand < horizontalPercent + verticalPercent + downDiagonalPercent) {
            return Direction.DIAGONAL_DOWN;
        } else {
            return Direction.DIAGONAL_UP;
        }
    }
}
