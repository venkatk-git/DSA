package  LeetCode.SearchInMatrix2.java;

public class SearchInMatri {
    public static void main(String[] args) {
        int[][] mat = { 
            {1, 4 ,7, 11, 16},
            {2, 5, 8, 12, 19},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix2(mat,10));
    }

    public static boolean searchMatrix2(int[][] mat, int target){
        int r = mat.length - 1;
        int c = 0;

        while(r >= 0 && c < mat[0].length){
            if(mat[r][c] == target)
                return true;
            
            if(mat[r][c] < target)
                c++;
            else 
                r--;
        }

        return false;
    }
}
