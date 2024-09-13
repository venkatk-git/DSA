package Graphs.ComponentCounts.java;

/**
 * ComponentCounts
 */
import  java.util.*;

public class ComponentCounts {
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
          
        System.out.println(connectedComponentsCount(graph));
    }

    /** Brute Force Approach By Iterating Through Every Single Entry of the Map 
    ** public static int connectedComponentsCount(Map<Integer, List<Integer>> graph){
    **    int count = 0;
    **
    **    Set<Integer> visited = new HashSet<>();
    **
    **    for(Map.Entry<Integer, List<Integer>> node : graph.entrySet()){
    **        if(!visited.contains(node.getKey())){
    **            boolean newComponent = true;
    **            visited.add(node.getKey());
    **
    **            for(Integer nodeValue : node.getValue()){
    **                if(visited.contains(nodeValue))
    **                    newComponent = false;
    **
    **                visited.add(nodeValue);
    **            }
    **
    **            if(newComponent)
    **                count += 1;
    **        }
    **    }
    **
    **    System.out.println(visited);
    **
    **    return count;
    ** }
    */

    /** Depth First Search **/
    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph){
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for(Integer node : graph.keySet())
            if(dfs(graph, node, visited))
                count += 1;

        return count;
    }

    public static boolean dfs(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited){
        if(visited.contains(node))
            return false;
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(node);

        while(!stack.isEmpty()){
            Integer currNode = stack.pop();

            for(Integer neighbour : graph.get(currNode)){
                if(!visited.contains(neighbour)){
                    stack.push(neighbour);
                    visited.add(neighbour);
                }
            }

            visited.add(currNode);
        }

        return true;
    }
}