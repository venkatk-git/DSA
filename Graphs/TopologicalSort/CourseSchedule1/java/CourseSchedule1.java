package Graphs.TopologicalSort.CourseSchedule1.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>(); 
        
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            
            graph.get(a).add(b);
        }
        
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(graph, visited, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Map<Integer, ArrayList<Integer>> graph, Set<Integer> visited, int src) {
        if(visited.contains(src)) {
            return false;
        }

        if(graph.get(src).isEmpty()) {
            return true;
        }

        visited.add(src);
        
        for(int course: graph.get(src)) {
            if(!dfs(graph, visited, course)) {
                return false;
            }
        }
        
        visited.remove(src);

        graph.put(src, new ArrayList<>());

        return true;
    }
}

public class CourseSchedule1 {
    public static void main(String[] args) {
        int[][] edges = {
            {0, 2},
            {1, 3},
            {1, 4},
            {3, 4}
        };

        System.out.println(new Solution().canFinish(5, edges));
    }
    
}