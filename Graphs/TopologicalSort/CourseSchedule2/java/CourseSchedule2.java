package Graphs.TopologicalSort.CourseSchedule2.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            graph.get(a).add(b);
        }

        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        for(int i = 0; i < numCourses; i++) {
            for(int course: graph.get(i)) {
                indegree[course] += 1;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int index = 0;
        while(!q.isEmpty()) {
            int currCourse = q.poll();
            order[index++] = currCourse;

            for(int course: graph.get(currCourse)) {
                indegree[course] -= 1;

                if(indegree[course] == 0) q.offer(course);
            }
        }

        return order.length == numCourses ? order : new int[]{};
    }

    int i = 0;

    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int[] visited, int[] order) {
        if(visited[src] == 1) {
            return false;
        }

        if(visited[src] == 2) {
            return true;
        }

        visited[src] = 1;

        for(int course: graph.get(src)) {
            if(!dfs(graph, course, visited, order)) {
                return false;
            }
        }

        order[i++] = src;
        visited[src] = 2;
        return true;
    }
}

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] edges = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] order = new Solution().findOrder(edges.length, edges);

        System.out.println(Arrays.toString(order));
    }
    
}