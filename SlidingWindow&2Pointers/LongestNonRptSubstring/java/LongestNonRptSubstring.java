import java.util.Arrays;

public class LongestNonRptSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        
        System.out.println(lengthOfLongestSubstring(s));
    }

    /* Sliding Window Approach */
    public static int lengthOfLongestSubstring(String s) {
        int[] cache = new int[126];
        Arrays.fill(cache, 0);

        int l = 0; 
        int r = 0;
        int res = 0;
        int currMax = 0;

        while(r < s.length()){
            if(cache[s.charAt(r)] == 0){
                currMax += 1;   
                cache[s.charAt(r)] += 1;
                r++;
            } else {
                currMax -= 1;
                cache[s.charAt(l)] -= 1;
                l++;
            }

            res = Math.max(res, currMax);
        }

        return res;
    }
}
