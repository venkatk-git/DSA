package Recursion.Subsets.java;

import java.util.ArrayList;

public class PossibleSubsets {
    public static void main(String[] args) {
        ArrayList<String> result = subSets(new ArrayList<>(), "abc");
        System.out.print(result); 
    }

    private static ArrayList<String> subSets(ArrayList<String> list, String s){
        if(s.isEmpty()) return list;

        list.add(s);
        return subSets(list, s.substring(1));
    }
}