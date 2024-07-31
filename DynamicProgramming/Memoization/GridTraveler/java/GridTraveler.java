package DynamicProgramming.Memoization.GridTraveler.java;

import java.util.*;

public class GridTraveler{
    public static void main(String[] args) {
        long result = gridTraveler(18, 18, new HashMap<>());
        System.out.println(result);
    }

    private static long gridTraveler(int r, int c, HashMap<String, Long> memo){
        String key = "" + r + ',' + c;
        if(memo.containsKey(key))
            return memo.get(key);

        if(r == 1 && c == 1){
            return 1;
        }
        
        if(r == 0 || c == 0)
            return 0;
        
        long count = 0;
        count += gridTraveler(r - 1, c, memo);
        count += gridTraveler(r, c - 1, memo);

        memo.put(key, count);

        return count;
    }


}