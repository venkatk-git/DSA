package DynamicProgramming.Hustle;

import java.util.HashMap;

public class CountConstruct {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaf";
        String[] wordBank = {"a", "aaa", "aaaaa", "aaaaa", "aaaaaaaa"};

        int result = countConstruct(s, wordBank, new HashMap<>());

        System.out.println(result);
    }

    private static boolean  isPresent(String s, String pre){
        int i = 0, j = 0;

        if(!s.isBlank() && pre.isBlank())
            return false;

        if(pre.length() > s.length())
            return false;

        while(i < s.length() && j < pre.length()){
            if(s.charAt(i++) != pre.charAt(j++)) 
                return false;
        }

        return true;
    }
    

    private static int countConstruct(String s, String[] wordBank, HashMap<String, Integer> memo){
        if(memo.containsKey(s))
            return memo.get(s);

        if(s.isBlank())
            return 1;
        
        int count = 0;
        for(String word : wordBank){
            if(isPresent(s, word)){
                count += countConstruct(s.substring(word.length()), wordBank, memo);
            }
        }

        memo.put(s, count);
        return count;
    }
}
