package org.infotoast.sentimentvalue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Review {
    private String[] reviews;
    public Review() throws FileNotFoundException {
        File reviewDirectory = new File("/Users/frank/Documents/ProgramData/SentimentValue");
        String[] contents = reviewDirectory.list();
        reviews = new String[contents.length];
        System.out.println("Listing out contents of review directory.");
        int i = 0;
        for (String file : contents) {
            System.out.println(" -> " + file);
            File f = new File("/Users/frank/Documents/ProgramData/SentimentValue/" + file);
            Scanner reader = new Scanner(f);
            String text = "";
            while (reader.hasNextLine()) {
                text += reader.nextLine();
            }
            reader.close();
            reviews[i] = text;
            i++;
        }
    }
    public void doSentimentValue() {
        for (String review : reviews) {
            System.out.println("Review: " + review);
            double totalValue = 0;
            for (String word : review.split(" ")) {
                System.out.println(" -> " + word);
                totalValue += WordList.getSentimentValue(word);
            }
            System.out.println("Total sentiment value: " + totalValue);
            System.out.println("Star rating: " + starRating(totalValue));
        }
    }

    private int starRating(double val) {
        if (val > 6) {
            return 4;
        } else if (val > 5) {
            return 3;
        } else if (val > 0) {
            return 2;
        } else {
            return 1;
        }
    }
    public String fakeReview(String fileName) throws FileNotFoundException {
        File f = new File("/Users/frank/Documents/ProgramData/SentimentValue/" + fileName);
        Scanner reader = new Scanner(f);
        String text = "";
        while (reader.hasNextLine()) {
            text += reader.nextLine();
        }
        String[] words = text.split(" ");
        String newReview = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("*")) {
                words[i] = WordList.getRandomWord();
            }
            newReview += words[i] + " ";
        }
        return newReview;
    }
}
