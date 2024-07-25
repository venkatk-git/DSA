package Backtracking.MazeDR.java;

import java.util.*;

public class MazeDR {
    public static  void main(String[] args) {
        ArrayList<String> ans = mazePathListDR(new ArrayList<>(), "", 2, 2);
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

    public static void mazePathDR(String path, int r, int c){
        if(r < 0 || c < 0)
            return;
        if(r == 0 && c == 0){
            System.out.println(path);
            return;
        }
        
        mazePathDR(path + 'D', r - 1, c);
        mazePathDR(path + 'R', r, c - 1);
    }

    public static ArrayList<String> mazePathListDR(ArrayList<String> list, String path, int r, int c){
        if(r < 0 || c < 0)
            return new ArrayList<>();
        if(r == 0 && c == 0)
            list.add(path);
        
        
        mazePathListDR(list, path + 'D', r - 1, c);
        mazePathListDR(list, path + 'R', r, c - 1);

        return list;
    }
}
