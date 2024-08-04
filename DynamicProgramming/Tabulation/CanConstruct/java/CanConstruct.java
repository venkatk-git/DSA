package DynamicProgramming.Tabulation.CanConstruct.java;

import java.util.*;

public class CanConstruct {
    public static void main(String[] args) {
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        String target = "abababccd";

        System.out.println(canConstruct(wordBank, target));
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
    
    private static boolean canConstruct(String[] wordBank, String target){
        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for(int i = 0; i <= target.length(); i++)
            for(String word : wordBank)
                if(table[i] && isPresent(target.substring(i), word))
                    table[i + word.length()] = true;

        return table[target.length()];
    }
}
