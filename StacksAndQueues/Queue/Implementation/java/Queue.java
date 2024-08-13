package StacksAndQueues.Queue.Implementation.java;

import java.util.LinkedList;

public class Queue {
    protected LinkedList<Integer> queue;
    
    public Queue(){
        queue = new LinkedList<>();
    }

    public boolean enqueue(int val){
        queue.addLast(val);
        return true;
    }

    public int dequeue(){
        if(queue.isEmpty())
            return -1;
        
        int val = queue.getFirst();
        queue.removeFirst();
        return val;
    }
}
