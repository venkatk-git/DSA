package Greedy.AssignCookies.java;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {3, 5, 2, 4, 1};
        int[] s = {1, 3, 7, 4};

        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);

        int children = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(s[j] >= g[i]){
                children += 1;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return children;
    }
}