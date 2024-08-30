package LeetCode.MakeABouquet.java;

import java.util.Arrays;

public class MakeABouquet {

    public static void main(String[] args) {
        int[] nums = {1542,5142,4695,4385,2629,2492,933,1068,151,3960,3790,1196,3842,5147,5526,5528,2259,1708,2714,5462,3016,3262,1175,4348,4826,80,789,5285,3855,3455,3480,4277,648,1748,625,4256,3931,4938,4553,2129,4480,824,3048,2383,3036,2192,2156,7,438,5258,2430,2459,3769,1694,1687,5130,70,3219,4140,2341,1159,3952,4934,4335,2786,3124,5344,803,4586,1000,2821,4769,629,4673,3920,3437,4533,2984,3576,5364,1255,1876,2309,5619,2402,1978,4127,1668,147,4139,292,1499,1786,2435,1988,146,500,3377,3789,1301,1193,1686,3501,3895,1321,1587,4263,593,1580,3652,1638,4905,1927,567,2797,2082,1349,4158,679,4944,4638,4770,3458,2117,2620,938,4121,2374,1478,5269,5548,5125,5237,1693,2188,690,4640,827,2721,2329,430,4423,5510,2312,2493,4884,223,1904,4660,5124,2851,5227,4160,694,5660,5571,834,1704,4550,988,573,3373,5419,311,4280,399,5319,4723,5467,1155,4267,303,4233,770,3087,3306,1042,4192,3736,893,5087,1903,3650,393,5304,2767,3562,5501,4789,1863,1653,2528,5521,3802,3925,2718,5402,2642,304,4171,4356,5486,1426,4526,4541,4310,2160,4542,2850,2396,1612,4780,3921,5219,2585,4027,1861,3799,101,1434,996,203,1216,1654,4382,3791,3417,1912,5337,814,352,3892,3851,3432,2400};
        System.out.println(minDays(nums, 49, 4));
    }

    public static int minDays(int[] bloomDays, int m, int k){
        int[] days = bloomDays;
        Arrays.sort(days);
        int n = days.length;

        int l = 0;
        int r = n - 1;
        int mid;
        int minDay = Integer.MAX_VALUE;
        while(l < r){
            mid = (l + r) / 2;

            int day = days[mid];
            System.out.println(canMake(bloomDays, m, k, 5364));
            if(canMake(bloomDays, m, k, day)){
                minDay = Math.min(minDay, day);
                r = mid - 1;
            }else 
                l = mid + 1;
        }
        
        return Math.min(days[l], minDay);
    }

    public static boolean canMake(int[] nums, int m, int k, int days){
        int flowersInBloom = 0;
        int bouquetCount = 0;
        int remainingFlowers = 0;
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= days) {
                flowersInBloom++;
                remainingFlowers++;
            } else {
                flowersInBloom = 0;
            }
    
            if (flowersInBloom == k) {
                flowersInBloom = 0;
                bouquetCount++;
                remainingFlowers -= k;
            }
        }
    
        return bouquetCount >= m && remainingFlowers >= (m - bouquetCount) * k;
    }
}