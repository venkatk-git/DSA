import java.util.*;

public class LongestSubstringWithK {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(maxLength(s, 2));
    }   

    private static int maxLength(String s, int k){
        int n = s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(k); 

        while(r < n){
            Character rCh = s.charAt(r);
            if(map.size() < k || map.containsKey(rCh))
                map.put(rCh, r);
            else {
                Character lCh = s.charAt(l);
                l = map.get(lCh) + 1;
                map.remove(lCh);
                map.put(rCh, r);
            }
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
