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

        //throw new RuntimeException("Couldn't find a letter!!!");
        // This should be ok, if we've guaranteed that the Letter Frequency is actually 100%,
        // or really, really close!
        return 'Z';
    }

    private final LetterFrequency letterFrequency;


    public static void main(String [] argv) {
        LetterFrequency letterFrequency = new LetterFrequency();
        RandomLetterGenerator randomLetterGenerator = new RandomLetterGenerator(letterFrequency);

        int [] testCount = new int[26];
        final int NUM_TEST_RUNS = 5000000;

        for (int i = 0; i < NUM_TEST_RUNS; i++) {
            char c = randomLetterGenerator.generateRandomLetter();
            testCount[c - 'A']++;
        }

        for (int i = 0; i < 26; i++){
            double runtimeDist = ((double)testCount[i] / (double)NUM_TEST_RUNS) * 100;
            char letter = (char)('A' + i);
            double freq = letterFrequency.getFrequency(letter);
            double percent_discrepancy = (freq - runtimeDist) / freq;
            System.out.printf("%c:  %.2f%%  %.2f  %.2f  %d%n", letter, percent_discrepancy, freq, runtimeDist, testCount[i]);
        }
    }
}
