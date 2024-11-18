package Graphs.MinimumPlatforms.java;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arv = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(findPlatform(arv, dep));
    }

    public static int findPlatform(int[] arv, int[] dep){
        int n = arv.length;
        int platforms = 0;
        int count = 0;
        int l = 0;
        int r = 0;
        Arrays.sort(arv);
        Arrays.sort(dep);

        while(l < n && r < n){
            if(arv[l] < dep[r]){
                l++;
                count += 1;
            } else {
                r++;
                count -= 1;
            }
            
            platforms = Math.max(platforms, count);
        }

        return platforms;
    }
    
}