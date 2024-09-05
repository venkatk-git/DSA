package SlidingWindowAnd2Pointers.LongestCharReplacement.java;

/**
 * LongestCharReplacement
 */
import java.util.*;
public class LongestCharReplacement {
    public static void main(String[] args) {
        String s = "CFGGGK";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }

    private static int characterReplacement(String s, int k) {
        int max = 0;
        
        int l = 0;
        int r = 0;
        Character ch = s.charAt(r);
        int maxOcc = 0;
        HashMap<Character, Integer> map = new HashMap<>(26);
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if(map.get(s.charAt(r)) > maxOcc){
                maxOcc = map.get(s.charAt(r));
                ch = s.charAt(r);
            }
            
            while((r - l + 1) - map.get(ch) > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            int currMax = 0;
            Character currCh = s.charAt(l);
            for(Character key : map.keySet()){
                if(currMax < map.get(key)){
                    currMax = map.get(key);
                    currCh = key;
                }
            }

            max = Math.max(max, r - l + 1);
            ch = currCh;
            r++;
        }

        return max;
    }
}