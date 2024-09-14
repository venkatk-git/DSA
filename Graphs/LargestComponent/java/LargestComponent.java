package Graphs.LargestComponent.java;

/**
 * LargestComponent
 */

import java.util.*;

public class LargestComponent {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.of(
            0, List.of(8, 1, 5),
            1, List.of(0),
            5, List.of(0, 8),
            8, List.of(0, 5),
            2, List.of(3, 4),
            3, List.of(2, 4),
            4, List.of(3, 2)
          );
     
        int maxSize = 0;

        Set<Integer> visited = new HashSet<>();

        for(Integer node : graph.keySet())
            maxSize = Math.max(maxSize, dfs(graph, visited, node));

        System.out.println(maxSize);
    }

    public static int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, Integer src){
        if(visited.contains(src))
            return 0;

        int size = 1;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(src);
        visited.add(src);

        while(!stack.isEmpty()){
            Integer currNode = stack.pop();

            for(Integer neighbour : graph.get(currNode)){
                if(!visited.contains(neighbour)){
                    stack.push(neighbour);
                    visited.add(neighbour);
                    size += 1;
                }
            }
        }

        return size;
    }
}