package Recursion.LetterCombinations.java;

import java.util.*;

public class LetterCombinations {
    static HashMap<Character, String> m = new HashMap<>();
    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }
    
    public static List<String> letterCombinations(String digits) {
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");

        return _letterCombinations(digits, "", new ArrayList<String>());
    }

    private static List<String> _letterCombinations(String up, String p, List<String> list){
        if(up.isEmpty()){
            if(p.isEmpty())
                return list;
                
            list.add(p);
            return list;
        }

        Character ch = up.charAt(0);
        String val = m.get(ch);

        for(int i = 0; i < val.length(); i++){
            _letterCombinations(up.substring(1), p + val.charAt(i), list);
        }    

        return list;
}
}
