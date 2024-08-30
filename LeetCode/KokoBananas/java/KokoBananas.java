/*
 * Leetcode 875 : Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
 * The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas 
 * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead 
 * and will not eat any more bananas during this hour.
 *   
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * 
 * Sample Input:
 * [3,6,7,11]
 * Output:
 * 8
 */

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

    /* Will it work util function */
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
