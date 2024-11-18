package Graphs.DFS.java;
import java.util.*;

public class DFS {
    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("e"),
            "d", List.of(),
            "e", List.of()
        );

        dfs(graph, "a");
    }

    public static void dfs(Map<String, List<String>> graph, String src){
        Stack<String> s = new Stack<>();
        s.push(src);

        while(!s.isEmpty()){
            String curr = s.pop();
            System.out.println(curr);

            for(String neighbor : graph.get(curr))
                s.push(neighbor);
        }
    }
}
