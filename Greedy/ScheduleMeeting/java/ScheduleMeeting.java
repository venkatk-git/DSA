package Greedy.ScheduleMeeting.java;

import java.util.Arrays;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m){
        return this.end - m.end;
    }

    @Override
    public String toString(){
        return "{Start time : " + start + ", End time : " + end + "}";
    }
}

public class ScheduleMeeting {
    public static void main(String[] args) {
        int[] startTimes = {1,3,0,5,8,5};
        int[] endTimes = {2,4,5,7,9,9};

        System.out.println(scheduleMeeting(startTimes, endTimes));
    }
    
    public static int scheduleMeeting(int[] startTimes, int[] endTimes){
        int n = startTimes.length;
        int count = 0;
        
        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i < n; i++){
            Meeting meeting = new Meeting(startTimes[i], endTimes[i]);
            meetings[i] = meeting;
        }
        
        Arrays.sort(meetings);

        count += 1;
        int i = 0;
        int j = 1;

        while(j < n){
            if(meetings[j].start > meetings[i].end){
                count += 1;
                i = j;
            }
            
            j += 1;
        }

        return count;
    }    
}
