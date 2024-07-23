package Recursion.Permutations.java;

public class Permutations {
    public static void main(String[] args) {
        permuString("abc", "");
    }

    private static void permuString(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++){
            String s = p.substring(0, i);
            String e = p.substring(i, p.length());
            permuString(up.substring(1), s + ch + e);
        }
    }
}
