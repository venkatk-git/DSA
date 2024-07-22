package Recursion.Combinations.java;

import java.util.ArrayList;

public class Combinations {
    public static void main(String[] args) {
        String s = "ABC";
        ArrayList<String> result = combinations(s, new ArrayList<>(), "");
        System.out.println(result);
    }

    public static ArrayList<String> combinations(String s, ArrayList<String> list, String p){
        if(s.length() == 0){
            list.add(p);
            return list;
        } 

        Character ch = s.charAt(0);
        s = s.substring(1);
        combinations(s, list, p + ch);
        combinations(s, list, p);

        return list;
    }
}
