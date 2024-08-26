package StacksAndQueues.Queue.Implementation.java;

public class CircularQueue {
    protected int[] queue;  
    private static final int DEFAULT_SIZE = 10;
    // private int start = 0;
    // private int end = 0;

    public CircularQueue(){
        this.queue = new int[DEFAULT_SIZE];
    }
}
