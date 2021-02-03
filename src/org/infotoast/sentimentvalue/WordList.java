package org.infotoast.sentimentvalue;

import java.util.Random;

public class WordList {
    private static Word[] words = {new Word("happily", 2.32), new Word("terrible", -3.38),
            new Word("cold", -0.04), new Word("chewy", 0.3), new Word("disliked", -2.0),
            new Word("dissapointed", -1.4), new Word("homemade", 1.5), new Word("sweet", 2.0),
            new Word("delicious", 3.2), new Word("better", 1.0), new Word("famous", 1.6),
            new Word("ok", -0.6), new Word("okay", -0.6), new Word("artificial", 0.2),
            new Word("dated", -0.7), new Word("good", 1.2), new Word("overcooked", -0.9),
            new Word("overcook", -0.9)};
    public static double getSentimentValue(String word) {
        for (Word w : words) {
            if (w.getStr().equals(word)) {
                return w.getValue();
            }
        }
        return 0.0;
    }
    public static String getRandomWord() {
        Random r = new Random();
        int i = r.nextInt(18);
        return words[i].getStr();
    }
}
