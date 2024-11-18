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
            Map.entry(5, List.of(0, 2, 4))
        );

        List<Integer> topoSortedList = topoSort(graph, 5);

        System.out.println(topoSortedList);
    }   
    
    private static List<Integer> topoSort(Map<Integer, List<Integer>> graph, int src) {
        List<Integer> topoSortedList = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();

        dfs(graph, src, visited, topoSortedList);

        return topoSortedList.reversed();
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int v, Set<Integer> visited, List<Integer> topoSortedList) {
        visited.add(v);

        if(graph.get(v).isEmpty()) {
            topoSortedList.add(v);
            return;
        }

        for(int vertex: graph.get(v)) {
            if(!visited.contains(vertex)) {
                dfs(graph, vertex, visited, topoSortedList);
            }
        }

        topoSortedList.add(v);
    }
}