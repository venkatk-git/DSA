package StacksAndQueues.Stack.ClebrityProblem.java;

public class ClelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 0}
        };
        
        System.out.println(findCelebrity(mat));
    }   
    
    public static int findCelebrity(int[][] mat){
        int n = mat.length;

        int l = 0;
        int r = n - 1;

        while(l < r){
            if(mat[l][r] == 0){
                r--;
            } else {
                l++;
            }
        }

        for(int i = 0; i < n; i++){
            if((i != l && mat[i][l] == 0) || mat[l][i] == 1){
                return -1;
            }
        }

        return l;
    }
}
