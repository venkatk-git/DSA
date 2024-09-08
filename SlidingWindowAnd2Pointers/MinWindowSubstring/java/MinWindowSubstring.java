package SlidingWindowAnd2Pointers.MinWindowSubstring.java;

/**
 * MinWindowSubstring
 */

import java.util.*;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t){
        String res = "";
        
        int l = 0;
        while(l < s.length() && !t.contains(s.charAt(l) + ""))
            l++;
        int r = l;

        Map<Character, Integer> map = new HashMap<>(t.length());

        for(int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        int count = 0;

        
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r)) > 0)
                    count += 1;
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
            }

            while(count == t.length()){
                if(res.isBlank() || res.length() > s.substring(l, r + 1).length())
                    res = s.substring(l, r + 1);

                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if (map.get(s.charAt(l)) > 0) 
                        count--;
                }
                l++;
            }
            
            r++;
        }
        
        return res;
    }
    
}