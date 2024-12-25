package SlidingWindowAnd2Pointers;

import cputils.FastReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenateStrings {
    static Set<String> permutations;
    static int wordLength;
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        String s = fastReader.nextLine();
        int n = fastReader.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = fastReader.nextLine();
        }

        System.out.println(findSubstring(s, words));
    }
    
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> startingIndexes = new ArrayList<>();

        permutations = new HashSet<>();
        wordLength = words[0].length();
        generatePermutations(words, new StringBuilder(), new HashSet<>());

        int start = 0;
        int end = wordLength * words.length - 1;

        while(end < s.length()) {
            String subString = s.substring(start, end + 1);
            
            if(permutations.contains(subString)) {
                startingIndexes.add(start);
            }

            start++;
            end++;
        }

        return startingIndexes;
    }

    private static void generatePermutations(String[] words, StringBuilder permutation, Set<Integer> visited) {
        if(permutation.length() == words.length * wordLength) {
            permutations.add(permutation.toString());
            return;
        }

        for(int currIndex = 0; currIndex < words.length; currIndex++) {
            if(!visited.contains(currIndex)) {
                visited.add(currIndex);
                permutation.append(words[currIndex]);
                generatePermutations(words, permutation, visited);
                permutation.replace(permutation.length() - wordLength, permutation.length(), "");
                visited.remove(currIndex);
            }
        }
    }
}
