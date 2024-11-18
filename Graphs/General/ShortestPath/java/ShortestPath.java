package Graphs.ShortestPath.java;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class ShortestPath {
    public static void main(String[] args) {
        List<List<String>> edges = List.of(
            List.of("a", "c"),
            List.of("a", "b"),
            List.of("c", "b"),
            List.of("c", "d"),
            List.of("b", "d"),
            List.of("e", "d"),
            List.of("g", "f")
          );
          
          
        System.out.println(shortestPath(edges, "e", "c"));
    }


    public static int shortestPath(List<List<String>> edges, String src, String dest){
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> graph = buildGraph(edges);
        Deque<SimpleEntry<String, Integer>> queue = new ArrayDeque<>();
        
        queue.offer(new AbstractMap.SimpleEntry<>(src, 0));
        visited.add(src);

        while(!queue.isEmpty()){
            SimpleEntry<String, Integer> entry = queue.poll();
            String node = entry.getKey();
            int distance = entry.getValue();

            if(node.equals(dest))
                return distance;
        
            for(String neighbour : graph.get(node)){
                if(!visited.contains(neighbour)){
                    queue.offer(new SimpleEntry<>(neighbour, distance + 1));                    
                    visited.add(neighbour);
                }
            }
        }
        
        return -1;
    }

    public static Map<String, List<String>> buildGraph(List<List<String>> edges){
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> edge : edges){
            String node1 = edge.get(0);
            String node2 = edge.get(1);

            if(!graph.containsKey(node1))
                graph.put(node1, new ArrayList<>());
            
            if(!graph.containsKey(node2))
                graph.put(node2, new ArrayList<>());
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return graph;
    }

}