package DynamicProgramming.Tabulation.CountConstruct.java;

import java.util.*;

public class CountConstruct {
    public static void main(String[] args) {
        String[] wordBank = {"purp", "p", "ur", "le", "purpl", "purple"};
        String target = "purple";

        int result = countConstruct(wordBank, target);
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

    private static int countConstruct(String[] wordBank, String target){
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);

        // '' -> Empty can be constructed
        table[0] = 1;
        
        for(int i = 0; i < target.length(); i++){
            for(String word : wordBank){
                if(table[i] != 0 && isPresent(target.substring(i), word))
                    table[i + word.length()] += table[i];                
            }
        }

        return table[target.length()];
    }
    
}
