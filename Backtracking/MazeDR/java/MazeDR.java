package Backtracking.MazeDR.java;

public class MazeDR {
    public static  void main(String[] args) {
        int ans = mazeDR(3, 3);

        System.out.println(ans);
    }   

    public static int mazeDR(int r, int c){
        if(r < 0 || c < 0)
            return 0;
        if(r == 0 && c == 0)
            return 1;
        
        int downCount = mazeDR(r - 1, c);
        int rightCount = mazeDR(r, c - 1);

        return downCount + rightCount;
    }
}
