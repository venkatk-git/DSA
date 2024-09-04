package LeetCode.LongestCommonSubseq.java;

import java.util.Arrays;

public class LongestCommonSubseq {
    public static void main(String[] args) {
        String text1 = "abijo";
        String text2 = "abc";

        System.out.println(longestCommonSubsequence(text1, text2));
    }   

    
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() > text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        
        int[][] memo = new int[text1.length()][text2.length()];
        for(int[] array : memo)
            Arrays.fill(array, -1);

        return longestCommonSubsequence(text1, text2, text1.length() - 1, text2.length() - 1, memo);
    }

        public static int longestCommonSubsequence(String t1, String t2, int i, int j, int[][] memo){
        if(i < 0 || j < 0)
            return 0;

        if(memo[i][j] != -1)
            return memo[i][j];


        if(t1.charAt(i) == t2.charAt(j)){
            return memo[i][j] = 1 + longestCommonSubsequence(t1, t2, i - 1, j - 1, memo);
        }
     
        int with = longestCommonSubsequence(t1, t2, i - 1, j, memo);
        int without = longestCommonSubsequence(t1, t2, i, j - 1, memo);

        memo[i][j] = Math.max(with, without);

        return Math.max(with, without);
    }
}
