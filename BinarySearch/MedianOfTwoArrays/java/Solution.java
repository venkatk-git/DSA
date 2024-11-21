package BinarySearch.MedianOfTwoArrays.java;

public class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;

        if(n2 < n1) return findMedianSortedArrays(b, a);

        int l = 0;
        int h = n1;
        int left = (n1 + n2 + 1) / 2;

        while(l <= h) {
            int m1 = (l + h) / 2;
            int m2 = left - m1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            
            if(m1 < n1) r1 = a[m1];
            if(m2 < n2) r2 = b[m2];

            if(m1 - 1 >= 0) l1 = a[m1 - 1];
            if(m2 - 1 >= 0) l2 = b[m2 - 1];

            if(l1 <= r2 && l2 <= r1) {
                if(n % 2 != 0){
                    return Math.max(l1, l2);
                } 

                return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            
            if(l1 > r2) h = m1 - 1;
            else l = m1 + 1;
        }

        return 0;   
    }
}
