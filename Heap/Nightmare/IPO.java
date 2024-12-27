package Heap.Nightmare;

import cputils.FastReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    public int c;
    public int p;
    
    public Pair(int c, int p) {
        this.c = c;
        this.p = p;
    }
}

public class IPO {
    public static void main(String args[]) {
        FastReader fastReader = new FastReader();
        int k = fastReader.nextInt();
        int w = fastReader.nextInt();
        int[] profits = Arrays.stream(fastReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] capital = Arrays.stream(fastReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
    
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        boolean[] taken = new boolean[n];
        Arrays.fill(taken, false);

        PriorityQueue<Integer> profitHeapq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        List<Pair> projects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            projects.add(new Pair(capital[i], profits[i]));
        }

        Collections.sort(projects, (p1, p2) -> Integer.compare(p1.c, p2.c));
        int capitalIndex = 0;
        
        for (int i = 0; i < k; i++) {
            while (capitalIndex < n && projects.get(capitalIndex).c <= w) { 
                profitHeapq.add(projects.get(capitalIndex).p);
                capitalIndex++;
            }

            if(profitHeapq.isEmpty()) break;
            w += profitHeapq.poll();
        }

        return w;
    }
}
