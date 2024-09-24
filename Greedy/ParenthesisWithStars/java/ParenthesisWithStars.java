package Greedy.ParenthesisWithStars.java;

public class ParenthesisWithStars {
    public static void main(String[] args){
        String s = "(*(*)";

        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s){
        int n = s.length();
        int min = 0; 
        int max = 0;

        for(int i = 0; i < n; i++){
            Character ch = s.charAt(i);
            
            switch (ch) {
                case '(' -> {
                    min += 1;
                    max += 1;
                }
                case ')' -> {
                    if(min - 1 < 0 && max - 1 < 0){
                        return false;
                    }

                    if(min - 1 >= 0){
                        min -= 1;
                    }

                    if(max - 1 >= 0){
                        max -= 1;
                    }
                }
                case '*' -> {
                    if(min - 1 >= 0){
                        min -= 1;
                    }
                    max += 1;
                }
            }
        }

        return min == 0 || max == 0;
    }

    /** RECURSIVE BRUTE FORCE (Time limit exceeded) **/
    public static boolean checkValidString(String s, int count, int i){
        if(count < 0){
            return false;
        }

        if(i == s.length()){
            return count == 0;
        }

        switch (s.charAt(i)) {
            case '*' -> {
                boolean keepAsOpen = checkValidString(s, count + 1, i + 1);
                boolean keepAsClose = checkValidString(s, count - 1, i + 1);
                boolean keepAsNothing = checkValidString(s, count, i + 1); 
                
                return keepAsOpen || keepAsClose || keepAsNothing;
            }
            case '(' -> {
                return checkValidString(s, count + 1, i + 1);
            }
            case ')' -> {
                return checkValidString(s, count - 1, i + 1);
            }
        }    
        
        return true;
    }    
}