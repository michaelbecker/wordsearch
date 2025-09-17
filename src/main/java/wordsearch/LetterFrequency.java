package wordsearch;

public class LetterFrequency {


    // Units of %, so 8.1 -> 8.1%, or 0.081...
    private static final double[] DEFAULT_FREQUENCIES = {
        8.2,  // A
        1.5,  // B
        2.8,  // C
        4.3,  // D
        12.7,  // E
        2.2,  // F
        2.0,  // G
        6.1,  // H
        7.0,  // I
        0.15,  // J
        0.77,  // K
        4.0,  // L
        2.4,  // M
        6.7,  // N
        7.5,  // O
        1.9,  // P
        0.095,  // Q
        6.0,  // R
        6.3,  // S
        9.1,  // T
        2.8,  // U
        0.98,  // V
        2.4,  // W
        0.15,  // X
        2.0,  // Y
        0.074  // Z
    };


    private double [] adjustedFrequencies;
    public static final double EPSILON = 0.0000000001;


    public LetterFrequency() {
        /*
         *  We need to adjust things because I've yet to find
         *  a published distribution that adds to 100% exactly.
         *  So we tweak the dist to guarantee this.
         */
        adjustedFrequencies = new double[26];
        double sum = 0;
        double calculated_discrepancy;

        do {
            sum = 0;
            for (int i = 0; i < 26; i++) {
                adjustedFrequencies[i] = DEFAULT_FREQUENCIES[i];
                sum += DEFAULT_FREQUENCIES[i];
            }

            double adj = (sum - 100.0) / 26;

            for (int i = 0; i < 26; i++) {
                adjustedFrequencies[i] -= adj;
            }

            sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += adjustedFrequencies[i];
            }

            calculated_discrepancy = Math.abs(sum - 100);

        } while ( calculated_discrepancy > EPSILON);
    }


    public double getFrequency(char letter) {
        letter = Character.toUpperCase(letter);
        if (letter < 'A' || letter > 'Z') {
            throw new IllegalArgumentException("Letter must be between A and Z");
        }
        return adjustedFrequencies[letter - 'A'];
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c = 'A'; c <= 'Z'; c++) {
            sb.append(c).append(": ").append(getFrequency(c)).append("%\n");
        }
        return sb.toString();
    }


    public static void main(String[] argv) {

        LetterFrequency letterFrequency = new LetterFrequency();
        double sum = 0;
        double prev_sum = 0;

        for (int i = 0; i < 26; i++) {
            char letter = (char)('A' + i);
            double freq = letterFrequency.getFrequency(letter);
            sum += freq;
            System.out.printf(  "%c: %.3f %.3f %.3f %n",
                                letter, freq, sum, sum - prev_sum);
            prev_sum = sum;
        }
    }

}
