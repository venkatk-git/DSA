package Heap.Blaze;

import cputils.FastReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    public int s;
    public int u;
    public int v;
    public int index;

    public Pair(int u, int v, int index) {
        this.u = u;
        this.v = v;
        this.index = index;
        s = u + v;
    }
}

public class KPairsWIthSmallSum {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int[] nums1 = Arrays.stream(fastReader.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(fastReader.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = fastReader.nextInt();

        System.out.println(kSmallestPairs(nums1, nums2, k));
    }    

    public static List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
        int n = n1.length;
        int m = n2.length;
        List<List<Integer>> pairs = new ArrayList<>();

        PriorityQueue<Pair> heapq = new PriorityQueue<>((p1, p2) -> p1.s - p2.s); 
        
        for (int i = 0; i < n; i++) {
            heapq.offer(new Pair(n1[i], n2[0], 0));
        }

        while (k > 0) {
            Pair p = heapq.poll();
            pairs.add(List.of(p.u, p.v));
            
            if (p.index + 1 < m) {
                heapq.offer(new Pair(p.u, n2[p.index + 1], p.index + 1));
            }

            k--;
        }

        return pairs;
    }
}
