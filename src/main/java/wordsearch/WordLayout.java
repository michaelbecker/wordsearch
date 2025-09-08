package wordsearch;

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
}
