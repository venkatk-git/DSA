package Graphs.TopologicalSort.CycleDetection;

import java.util.*;

public class CycleDetection {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.ofEntries(
            Map.entry(0, List.of(1)),
            Map.entry(1, List.of(2)),
            Map.entry(2, List.of(3)),
            Map.entry(4, List.of(2)),
            Map.entry(5, List.of())
        );     

        System.out.println(isThereCycle(graph));
    }

    private static boolean isThereCycle(Map<Integer, List<Integer>> graph) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] indegree = new int[graph.size()];

        Arrays.fill(indegree, 0);
        for(Integer key: graph.keySet()) {
            for(Integer v: graph.get(key)) {
                indegree[v]++;
            }
        }

        for(int i = 0; i < graph.size(); i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for(Integer v: graph.get(curr)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return count != graph.size();
    }
}