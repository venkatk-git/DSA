package SlidingWindowAnd2Pointers;

import cputils.FastReader;
import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        String s = fastReader.nextLine();

        System.out.println(lengthOfLongestSubstring(s));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int[] indexCache = new int[256];
        Arrays.fill(indexCache, -1);

        int maxLength = 0;
        int start = 0;
        int end = 0;
        while(end < s.length()) {
            char ch = s.charAt(end);
            
            if(indexCache[ch] != -1 && indexCache[ch] >= start) {
                start = indexCache[ch] + 1;                     
            }   

            indexCache[ch] = end;
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}