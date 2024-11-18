package Graphs.BFS.java;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("e"),
            "d", List.of(),
            "e", List.of()
        );

        bfs(graph, "a");
    }

    public static void bfs(Map<String, List<String>> graph, String src){
        Queue<String> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            String curr = q.poll();
            System.out.println(curr);

            for(String neighbor : graph.get(curr))
                q.add(neighbor);
        }
    }
}
