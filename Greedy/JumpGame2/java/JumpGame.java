package Greedy.JumpGame2.java;

public class JumpGame {
    public static int jump(int[] nums){
        int n = nums.length; 
        int jumps = 0;
        int l = 0;
        int r = 0;

        while(r < n - 1){
            int farthest = 0;

            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps += 1;
        }

        return jumps;
    }
}
