package LeetCode;

import java.util.Arrays;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
    
    public static String longestPalindrome(String s) {
        int[] pal = {0, 0};
        int[][] dp = new int[s.length()][s.length()];

        for(int[] r: dp) {
            Arrays.fill(r, -1);
        }

        longestPalindrome(s, 0, s.length() - 1, pal, dp);

        return s.substring(pal[0], pal[1] + 1);
    }

    private static void longestPalindrome(String s, int i, int j, int[] pal, int[][] memo) {
        if(i == j) {
            return;
        }

        if(memo[i][j] != -1) {
            int len = memo[i][j];
            
            if(len > (pal[1] - pal[0] + 1)) {
                pal[0] = i;
                pal[1] = j;
            }
            
            return;
        }

        if(isPal(s, i, j) && (j - i + 1) > (pal[1] - pal[0] + 1)) {
            pal[0] = i;
            pal[1] = j;
            memo[i][j] = j - i + 1;
        }

        // include
        longestPalindrome(s, i + 1, j, pal, memo);

        // not include
        longestPalindrome(s, i, j - 1, pal, memo);
    }

    private static boolean isPal(String s, int i, int j) {
        int l = i;
        int r = j;

        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {    
                return false;
            }
            l++; r--;
        }

        return true;
    }
}
