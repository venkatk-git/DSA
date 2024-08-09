package DynamicProgramming.Memoization.WorkBreak.java;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String sCase1 = "leetcode";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet"); wordDict1.add("code");
        System.out.println("Case 1: " + wordBreak(sCase1, wordDict1, new HashMap<>()));
        
        String sCase2 = "applepenapple";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple"); wordDict2.add("pen");
        System.out.println("Case 2: " + wordBreak(sCase2, wordDict2, new HashMap<>()));
        
        String sCase3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats"); wordDict3.add("dog"); wordDict3.add("sand"); wordDict3.add("and"); wordDict3.add("cat"); 
        System.out.println("Case 3: " + wordBreak(sCase3, wordDict3, new HashMap<>()));

        String sCase4 = "ccbb";
        List<String> wordDict4 = new ArrayList<>();
        wordDict4.add("cb"); wordDict4.add("bc");  
        System.out.println("Case 4: " + wordBreak(sCase4, wordDict4, new HashMap<>()));
    }

    private static boolean wordBreak(String s, List<String> wordDict, HashMap<String, Boolean> memo){
        if(memo.containsKey(s))
            return memo.get(s);

        if(s.isBlank())
            return true;
        
        for(String word : wordDict){
            if(s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict, memo)){
                memo.put(s, true);
                return true;
            }            
        }

        memo.put(s, false);
        return false;
    }
}