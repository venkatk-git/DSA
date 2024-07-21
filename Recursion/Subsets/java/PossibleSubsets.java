package Recursion.Subsets.java;

import java.util.ArrayList;

public class PossibleSubsets {
    public static void main(String[] args) {
        ArrayList<String> result = subsequence(new ArrayList<>(),"abc","");
    
        System.out.print(result); 
    }

    private static ArrayList<String> subSets(ArrayList<String> list, String s){
        if(s.isEmpty()) return list;

        list.add(s);
        return subSets(list, s.substring(1));
    }

    private static ArrayList<String> subsequence(ArrayList<String> list, String s, String a){
        if(s.isEmpty()){
            list.add(a);
            return list;
        } 
        
        char ch = s.charAt(0);

        subsequence(list, s.substring(1), a + ch);
        subsequence(list, s.substring(1), a);
        
        return list;
    }
}