package LeetCode;

import cputils.FastReader;
import java.time.Duration;
import java.time.Instant;

public class LexicographicallyLargestString {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        String word = fastReader.nextLine();
        int numFriends = fastReader.nextInt();


        Instant start = Instant.now();
        System.out.println(answerString(word, numFriends));
        Instant end = Instant.now();
        System.out.println("Time taken: " + Duration.between(start, end).toSeconds() + " seconds");
    }

    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();
        int m = n - numFriends + 1;
        String largestString = "";
        
        for (int i = 0; i < n; i++) {
            String substring = word.substring(i, Math.min(i + m, n));        
            if (substring.compareTo(largestString) > 0) {
                largestString = substring;
            }
        }
        
        return largestString;  
    }
}