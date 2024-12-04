package DynamicProgramming.Nightmare;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String sCase1 = "leetcode";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet"); wordDict1.add("code");
        int[] dp1 = new int[sCase1.length()];
        Arrays.fill(dp1, -1);
        System.out.println("Case 1: " + wordBreak(sCase1, wordDict1, 0, dp1));
        
        String sCase2 = "applepenapple";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple"); wordDict2.add("pen");
        int[] dp2 = new int[sCase2.length()];
        Arrays.fill(dp2, -1);
        System.out.println("Case 2: " + wordBreak(sCase2, wordDict2, 0, dp2));
        
        String sCase3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats"); wordDict3.add("dog"); wordDict3.add("sand"); wordDict3.add("and"); wordDict3.add("cat"); 
        int[] dp3 = new int[sCase3.length()];
        Arrays.fill(dp3, -1);
        System.out.println("Case 3: " + wordBreak(sCase3, wordDict3, 0, dp3));
        
        String sCase4 = "ccbb";
        List<String> wordDict4 = new ArrayList<>();
        wordDict4.add("cb"); wordDict4.add("bc");  
        int[] dp4 = new int[sCase4.length()];
        Arrays.fill(dp4, -1);
        System.out.println("Case 4: " + wordBreak(sCase4, wordDict4, 0, dp4));
    }

    private static boolean wordBreak(String og, List<String> wordDict, int i, int[] dp) {
        if(i == og.length()) {
            return true;
        }

        if(dp[i] != -1) {
            return dp[i] == 1;
        }

        boolean canConstruct = false;
        for(String word: wordDict) {
            if(startsWith(og, word, i) && wordBreak(og, wordDict, i + word.length(), dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return canConstruct;
    }

    private static boolean startsWith(String s, String word, int i) {
        if(s.length() - i < word.length()) {
            return false;
        }

        int j = 0;
        while(j < word.length() && s.charAt(i) == word.charAt(j)) {
            i++;
            j++;
        }

        return j == word.length();
    }
}