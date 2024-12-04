package DynamicProgramming.Blaze;

import java.util.*;

public class AllConstruct {
    public static void main(String[] args) {
        String s = "aaaaaaaaa";
        String[] wordBank = {"a", "aa", "aaa", "aaaaa", "aaaaaaa"};
        ArrayList<ArrayList<String>> lists = allConstruct(s, wordBank, new HashMap<>());

        for(ArrayList<String> list : lists){
            System.out.println(list);
        }
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
    

    private static ArrayList<ArrayList<String>> allConstruct(String s, String[] wordBank, HashMap<String,ArrayList<ArrayList<String>>> memo ){
        if(memo.containsKey(s))
            return memo.get(s);
        
        if(s.isEmpty()){
            ArrayList<ArrayList<String>> baseResult = new ArrayList<>();
            baseResult.add(new ArrayList<>());
            return baseResult;
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        for(String word : wordBank){
            if(isPresent(s, word)){
                ArrayList<ArrayList<String>> suffixWays = allConstruct(s.substring(word.length()), wordBank, memo);

                for(ArrayList<String> way : suffixWays){
                    ArrayList<String> targetWay = new ArrayList<>(way);
                    targetWay.add(0, word);
                    result.add(targetWay);
                }

            }
        }

        memo.put(s, result);
        return result;
    }
}
