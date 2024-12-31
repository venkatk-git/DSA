package Backtracking.Blaze;

import java.util.*;

public class PhoneNumberCombinations {
    Map<Character, String> map = new HashMap<>();
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) return combinations; 

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterCombinations(digits, 0, new StringBuilder());
        return combinations;
    }

    /**
     1) @params i - for current character in the given digits string.
     2) @params combination - for current formed combination so far. 
     3) @params combinations - List<String> all possible combinations.
     4) Base case - When, i goes out of bound add current combination to combinations list. 
     5) Loop over the mapped string to current character.
        - call the func recursively by passing i + 1, combination + current character, combinations list;
        - bactrack;
    */

    public void letterCombinations(String digits, int i, StringBuilder combination) {
        if (i == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        String letters = map.get(digits.charAt(i));
        for (int chIndex = 0; chIndex < letters.length(); chIndex++) {
            combination.append(letters.charAt(chIndex));
            letterCombinations(digits, i + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}