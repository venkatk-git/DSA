package DynamicProgramming.Memoization.CanContruct.java;

import java.util.HashMap;

public class CanConstruct {
    public static void main(String[] args){
        String[] sArr = {
            "e",
            "y",
            "xxd",
            "eeed",
            "abc",
            "eeeff",
            "f"
        };

        boolean result = canConstruct("", sArr, new HashMap<>());
        System.out.println(result);   
    }

    private static boolean  isPresent(String s, String pre){
        int i = 0, j = 0;

        if(pre.length() > s.length())
            return false;

        while(i < s.length() && j < pre.length()){
            if(s.charAt(i++) != pre.charAt(j++)) 
                return false;
        }

        return true;
    }
    
    private static boolean canConstruct(String s, String[] sArr,  HashMap<String, Boolean> memo){
        if(memo.containsKey(s))
            return memo.get(s);

        if(s.isEmpty())
            return true;
        
        for(String word : sArr){
            if(isPresent(s, word)){
                boolean result = canConstruct(s.substring(word.length()), sArr, memo);     
                if(result){
                    memo.put(s, true);
                    return true;
                }
            }
        }
        
        memo.put(s, false);
        return false;
    }
}
