package Graphs.TopologicalSort.TopoSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopoSort {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.ofEntries(
            Map.entry(0, List.of()),
            Map.entry(1, List.of()),
            Map.entry(2, List.of(3)),
            Map.entry(3, List.of(1)),
            Map.entry(4, List.of(0, 1)),
            Map.entry(5, List.of(0, 4))
        );

        List<Integer> topoSortedList = topoSort(graph, 5);

        System.out.println(topoSortedList);
    }   
    
    private static List<Integer> topoSort(Map<Integer, List<Integer>> graph, int src) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> topoSort = new ArrayList<>();

        for(int node: graph.keySet()) {
            if(!visited.contains(node)) {
                dfs(graph, node, visited, topoSort);
            }
        }

        return topoSort;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int src, Set<Integer> visited, List<Integer> topoSort) {
        if(visited.contains(src)) {
            return;
        }
        
        visited.add(src);

        for(int node: graph.get(src)) {
            if(!visited.contains(node)) {
                dfs(graph, node, visited, topoSort);
            }
        }

        topoSort.add(src);
    }
}