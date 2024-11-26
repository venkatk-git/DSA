package Graphs.TopologicalSort.TopoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TopoSort {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.ofEntries(
            Map.entry(0, List.of()),
            Map.entry(1, List.of()),
            Map.entry(2, List.of(3)),
            Map.entry(3, List.of(1)),
            Map.entry(4, List.of(0, 1)),
            Map.entry(5, List.of(0, 2))
        );

        List<Integer> topoSort = new ArrayList<>();

        int[] indegree = new int[graph.size()];
        Arrays.fill(indegree, 0);

        for(int i = 0; i < graph.size(); i++) {
            for(int v: graph.get(i)) {
                indegree[v] += 1;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < graph.size(); i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }

        }

        while(!q.isEmpty()) {
            int curr = q.poll(); 
            topoSort.add(curr);

            for(int v: graph.get(curr)) {
                indegree[v] -= 1;
                if(indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        System.out.println(topoSort);
    }   
    
}