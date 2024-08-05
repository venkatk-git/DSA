package DynamicProgramming.Tabulation.AllConstruct.java;

import java.util.*;

public class AllConstruct {
    public static void main(String[] args) {
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd",  "ef", "c"};
        String target = "abcdef";
    
        ArrayList<ArrayList<String>> result = allConstruct(wordBank, target);
        System.out.println("[");
        for(ArrayList<String> arr : result)
            System.out.println("  " + arr);
        System.out.println("]");
    }
    
    private static ArrayList<ArrayList<String>> allConstruct(String[] wordBank, String target){
        ArrayList<ArrayList<ArrayList<String>>> table = new ArrayList<>(target.length() + 1);
        
        for(int i = 0; i < target.length() + 1; i++)
            table.add(new ArrayList<>());        

        table.get(0).add(new ArrayList<>());

        for(int i = 0; i <= target.length(); i++){
            for(String word : wordBank){
                
                if(target.substring(i).startsWith(word) && !table.get(i).isEmpty()) {
                    ArrayList<ArrayList<String>> combinations = new ArrayList<>();

                    for(ArrayList<String> subList : table.get(i)){
                        ArrayList<String> combination = new ArrayList<>(subList);
                        combination.add(word);
                        combinations.add(combination);
                    }
                    
                    table.get(i + word.length()).addAll(combinations);
                }
                
            }
        
        }

        return table.get(target.length());
    }
}


