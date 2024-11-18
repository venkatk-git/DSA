package Graphs.ComponentCounts.java;

import  java.util.*;

class Solution {
    public int numProvinces(List<List<Integer>> adj, int v){
        int count = 0;
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                dfs(adj, visited, i);
                count += 1;
            }
        }

        return count;
    }

    public void dfs(List<List<Integer>> adj, boolean[] visited, int i){
        for(int j = 0; j < adj.size(); j++){
            if(i != j && adj.get(i).get(j) == 1 && !visited[j]){
                visited[j] = true;
                dfs(adj, visited, j);
            }
        }
    }
}

public class ComponentCounts {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.of(
            0, List.of(1, 8, 7),
            1, List.of(6, 8, 0),
            8, List.of(1, 0, 5),
            7, List.of(0),
            5, List.of(8),
            6, List.of(1)
          );
         
        List<List<Integer>> adj = List.of(
            List.of(1, 0, 1),
            List.of(0, 1, 0),
            List.of(1, 0, 1)
        );

        Solution solution = new Solution();  
        System.out.println(solution.numProvinces(adj, 3));
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