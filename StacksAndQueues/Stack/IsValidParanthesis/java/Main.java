public class Main{
    public static void main(String[] args) {
        String s = "((())))";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else 
                count--;
            
            if(count < 0)
                break;
        }

        return count == 0;
    }
}