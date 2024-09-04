package LeetCode.EditDistance.java;

import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println(editDistance(s1, s2));
    }

    public static int editDistance(String s1, String s2){
        int[][] memo = new int[s1.length()][s2.length()];
        for(int[] array : memo)
            Arrays.fill(array, -1);

        return editDistance(s1, s2, 0, 0, memo);
    }

    public static int editDistance(String s1, String s2, int i, int j, int[][] memo){
        if(i == s1.length())
            return s2.length() - j;
        if(j == s2.length())
            return s1.length() - i; 
        
        if(memo[i][j] != -1)
            return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return editDistance(s1, s2, i + 1, j + 1, memo);
        
        int insert = 1 + editDistance(s1, s2, i, j + 1, memo);
        int delete = 1 + editDistance(s1, s2, i + 1, j, memo);
        int replace = 1 + editDistance(s1, s2, i + 1, j + 1, memo);

        memo[i][j] = Math.min(Math.min(insert, delete), replace);
        return Math.min(Math.min(insert, delete), replace);
    }
}
