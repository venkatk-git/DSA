package LeetCode.KokoBananas.java;

public interface KokoBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        System.out.println(minEatingSpeed(piles, 8));   
    }

    /** Brute Force Approach
    ** public static int minEatingSpeed(int[] piles, int h){
    **    int n = piles.length;
    **    int totalHrs = 0;
    **    int speed = 1;
    **
    **    while(true){
    **        boolean flag = true;
    **        for(int i = 0; i < n; i++){
    **            totalHrs += Math.ceil((double)piles[i] / speed);
    **
    **            if(totalHrs > h){
    **                flag = false;
    **                break;
    **            }
    **        }
    **
    **        if(flag)
    **            return speed;
    **        
    **        speed += 1;
    **        totalHrs = 0;
    **    }
    ** }
    */

    /* Binary Search Approach */
    public static int minEatingSpeed(int[] piles, int h){
        int maxElement = piles[0];
        for(int e : piles)
            maxElement = Math.max(maxElement, e);
        
        int l = 1;
        int r = maxElement;
        int m;

        while(l <= r){
            if(l == r)
                break;
            
            m = (l + r) / 2;

            if(willItWork(piles, h, m))
                r = m;
            else 
                l = m + 1;
        }
        
        return l;
    }

    public static boolean willItWork(int[] piles, int h, int speed){
        int n = piles.length;
        int totalHrs = 0;

        for(int i = 0; i < n; i++){
            totalHrs += Math.ceil((double)piles[i] / speed);

            if(totalHrs > h)
                return false;
        }

        return true;
    }
}
