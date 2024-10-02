package Greedy.JobSequence.java;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Job{
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class CompareByProfit implements Comparator<Job>{
    @Override
    public int compare(Job j1, Job j2){
        return j2.profit - j1.profit;
    }
}

public class JobSequence {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1,2,100),
            new Job(2,1,19),
            new Job(3,2,27),
            new Job(4,1,25),
            new Job(5,1,15)
        };

        System.out.println(Arrays.toString(JobScheduling(jobs)));
    }

    public static int[] JobScheduling(Job[] jobs){
        int[] res = {0, 0};

        Arrays.sort(jobs, new CompareByProfit());

        HashSet<Integer> set = new HashSet<>();

        for(Job job : jobs){
            int profit = job.profit;
            int deadline = job.deadline;

            if(!set.contains(deadline)){
                res[0] += 1;
                res[1] += profit;
                set.add(deadline);
            } else {
                deadline -= 1;
                while(deadline > 0 && set.contains(deadline)){
                    deadline -= 1;
                }

                if(deadline > 0){
                    res[0] += 1;
                    res[1] += profit;
                    set.add(deadline);
                }
            }
        }

        return res;
    }
    
}