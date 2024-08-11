package DynamicProgramming.Memoization.DecodeWays.java;

import java.util.HashMap;

public  class DecodeWays{
    public static void main(String[] args) {
        String s1 = "12";
        System.out.println(numDecodings(s1));
        
        String s2 = "226";
        System.out.println(numDecodings(s2));
        
        String s3 = "256392106";
        System.out.println(numDecodings(s3));
    }

    private static int numDecodings(String s){
        return _numDecodings(s, new HashMap<>());
    }

    private static int _numDecodings(String s, HashMap<String, Integer> memo){
        if(memo.containsKey(s))
            return memo.get(s);
        
        if(s.isBlank())
            return 1;

        if(s.startsWith("0"))
            return 0;
        
        int takeOne = _numDecodings(s.substring(1), memo);
        int takeTwo = 0;

        if(s.length() > 1){
            int num = Integer.parseInt(s.substring(0, 2));
            if(num > 0 && num < 27)
                takeTwo = _numDecodings(s.substring(2), memo);
        }
        
        memo.put(s, takeOne + takeTwo);
        return takeOne + takeTwo;
    }
}