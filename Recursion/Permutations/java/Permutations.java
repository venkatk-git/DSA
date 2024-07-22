package Recursion.Permutations.java;

public class Permutations {
    public static void main(String[] args) {
        System.out.println("helo");
    }

    private static void permuString(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        Character ch = up.charAt(0);

        for(int i = 0; i < up.length(); i++){
            String f = up.substring(0, i);
            String e = up.substring(i, up.length());

            permuString(f + ch + e, p);
        }
    }
}
