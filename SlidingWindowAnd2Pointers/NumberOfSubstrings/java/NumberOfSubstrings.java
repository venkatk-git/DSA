package SlidingWindowAnd2Pointers.NumberOfSubstrings.java;
/**
 * NumberOfSubstrings
 */
public class NumberOfSubstrings {
    public static void main(String[] args) {
        String s = "abcabc";

        System.out.println(numberOfSubstringsOP(s));
    }

    /* Two different Brute Force Approaches (Time Limit Exceeded) */
    public static int numberOfSubstringsBF(String s){
        int count = 0;

        /** Full Brute Force (23 / 54)
        ** for(int l = 0; l < s.length(); l++)
        **    for(int r = l + 2; r < s.length(); r++)
        **        if(isValidSubstring(s.substring(l, r + 1)))
        **            count += 1;
        */

        /** Better Brute Force (53 / 54) **/
        for(int l = 0; l < s.length(); l++)
            for(int r = l + 2; r < s.length(); r++)
                if(isValidSubstring(s.substring(l, r + 1))){
                    count += s.length() - r;
                    break;
                }

        return count;
    }
    
    /* Sliding Window (53 / 54) */
    public static int numberOfSubstringsSW(String s){
        int count = 0;

        int l = 0;
        int r = 2;
        while(r < s.length()){
            if(isValidSubstring(s.substring(l, r + 1))){
                count += s.length() - r;
                l++;
            } else 
                r++;
        }
        
        return count;
    }

    /* Optimized Sliding Window */
    public static int numberOfSubstringsOP(String s){
        int n = s.length();
        int count = 0;

        /** Using Hash Map 
        ** Map<Character, Integer> map = new HashMap<>(3);
        ** map.put('a', -1);
        ** map.put('b', -1);
        ** map.put('c', -1);
        ** int i = 0;
        ** while(i < n){
        **     map.put(s.charAt(i), i);
        **     if(map.get('a') != -1 && map.get('b') != -1 && map.get('c') != -1)
        **         count += min(map.get('a'), map.get('b'), map.get('c')) + 1;
        **     i++;
        ** }
        */

        /* Without using Hash Map */
        int a = -1;
        int b = -1;
        int c = -1;
        int i = 0;
        while(i < n){
            if(s.charAt(i) == 'a')
                a = i;
            if(s.charAt(i) == 'b')
                b = i;
            if(s.charAt(i) == 'c')
                c = i;
            
            if(a != -1 && b != -1 && c != -1)
                count += min(a, b, c) + 1;
            
            i++;
        }
        
        return count;
    }

    /* Utility function to check wheather the substring is acceptable or not */
    private static boolean isValidSubstring(String s){
        boolean a = false;
        boolean b = false;
        boolean c = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a')
                a = true;
            if(s.charAt(i) == 'b')
                b = true;
            if(s.charAt(i) == 'c')
                c = true;
        }
               
        return a && b && c;
    }

    private static int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}