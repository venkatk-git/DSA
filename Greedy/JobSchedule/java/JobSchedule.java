package Greedy.JobSchedule.java;

import java.util.*;

/**
 * JobSchedule
 */
public class JobSchedule {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(5, 200),
            new Job(5, 200),
            new Job(3, 180),
            new Job(3, 190),
            new Job(2, 300),
            new Job(4, 120),
            new Job(2, 100)
        };

        System.out.println(maxProfit(jobs));
    }

    private static int maxProfit(Job[] jobs){
        Arrays.sort(jobs, (j1, j2) -> j2.profit - j1.profit);

        int deadline = 0;
        for(Job job : jobs)
            deadline = Math.max(job.deadline, deadline);

        int[] gc = new int[deadline];
        Arrays.fill(gc, 0);
        
        int maxProfit = 0;
        for(int i = 0; i < deadline; i++){
            int j = jobs[i].deadline - 1;
            
            while (j >= 0 && gc[j] == 1)
                j--;
            
            if(j >= 0){
                gc[j] = 1;
                maxProfit += jobs[i].profit;
            }
        }

        return maxProfit;
    }
}

class Job{
    int deadline;
    int profit;

    Job(int deadline, int profit){
        this.deadline = deadline;
        this.profit = profit;
    }

    public String toString(){
        return "Deadline : " + deadline + ", Profit : " + profit;
    }
}