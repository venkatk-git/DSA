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

        return index == numCourses ? reverse(order) : new int[]{};
    }
   
    private int[] reverse(int[] nums) {
        int n = nums.length;    
        int l = 0;
        int r = n - 1;

        while(l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        return nums;
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