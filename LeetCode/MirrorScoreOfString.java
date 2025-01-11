package LeetCode;

import cputils.FastReader;
import java.util.*;


public class MirrorScoreOfString {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        String s = fastReader.nextLine();

        System.out.println(calculateScore(s));
    }    

    public static long calculateScore(String s) {
        Map<Character, Deque<Integer>> freq = new HashMap<>();
        long score = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char mirror = (char) ('z' - (ch - 'a'));

            if (freq.containsKey(mirror) && !freq.get(mirror).isEmpty()) {
                score += (i - freq.get(mirror).pop());
            } else {
                Deque<Integer> q = freq.getOrDefault(ch, new ArrayDeque<>());
                q.push(i);
                freq.put(ch, q);
            }
        }

        return score;
    }
}
