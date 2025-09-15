package wordsearch;

import java.util.Random;

public class SafeRandom extends Random 
{

    public int nextIntSafe(int bound)
    {
        if (bound == 0)
            return 0;
        else
            return nextInt(bound);
    }
}
