package wordsearch;

import java.util.Random;

public class RandomLetterGenerator {

    public RandomLetterGenerator (LetterFrequency letterFrequency) {
        this.letterFrequency = letterFrequency;
    }

    public char generateRandomLetter() {
        Random random = new Random();
        double rand = random.nextDouble() * 100; // Scale to 0-100
        double cumulative = 0.0;

        for (char c = 'A'; c <= 'Z'; c++) {
            cumulative += letterFrequency.getFrequency(c);
            if (rand < cumulative) {
                return c;
            }
        }
        return 'Z'; // Fallback, should not reach here
    }

    private final LetterFrequency letterFrequency;
}
