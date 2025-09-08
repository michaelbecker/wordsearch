package wordsearch;

public class LetterFrequency {

    private static final double[] DEFAULT_FREQUENCIES = {
        8.167, // A
        1.492, // B
        2.782, // C
        4.025, // D
        12.702, // E
        2.228, // F
        2.015, // G
        6.094, // H
        6.966, // I
        0.153, // J
        0.772, // K
        4.025, // L
        2.406, // M
        6.749, // N
        7.507, // O
        1.929, // P
        0.095, // Q
        5.987, // R
        6.327, // S
        9.056, // T
        2.758, // U
        0.978, // V
        2.360, // W
        0.150, // X
        1.974, // Y
        0.074  // Z
    };

    public double getFrequency(char letter) {
        letter = Character.toUpperCase(letter);
        if (letter < 'A' || letter > 'Z') {
            throw new IllegalArgumentException("Letter must be between A and Z");
        }
        return DEFAULT_FREQUENCIES[letter - 'A'];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c = 'A'; c <= 'Z'; c++) {
            sb.append(c).append(": ").append(getFrequency(c)).append("%\n");
        }
        return sb.toString();
    }
}
