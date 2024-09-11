package Graphs.HasPath.java;

import java.util.*;

public class HasPath {
    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
        "f", List.of("g", "i"),
        "g", List.of("h"),
        "h", List.of(),
        "i", List.of("g", "k"),
        "j", List.of("i"),
        "k", List.of()
        );

        System.out.println(hasPath(graph, "f", "h"));
    }   

    /** Using Depth First Search
    ** public static boolean hasPath(Map<String, List<String>> graph, String src, String dest){
    **    Deque<String> s = new ArrayDeque<>();
    **    s.push(src);
    **
    **    while(!s.isEmpty()){
    **        String currNodeKey = s.pop();
    **        if(currNodeKey.equals(dest))
    **            return true;
    **        
    **        List<String> currNode = graph.get(currNodeKey);
    **
    **        for(String neighbour : currNode)
    **            s.push(neighbour);
    **    }
    **
    **    return false;
    **}
    */

    /* Using Breadth First Search */
    public static boolean hasPath(Map<String, List<String>> graph, String src, String dest){
        Queue<String> s = new LinkedList<>();
        s.add(src);

        while(!s.isEmpty()){
            String currNode = s.remove();
            if(currNode.equals(dest))
                return true;

            for(String neighbour : graph.get(currNode))
                s.add(neighbour);
        }

        return false;
    }
}
