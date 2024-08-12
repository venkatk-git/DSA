package StacksAndQueues.Stack.Implementation.java;

public class Stack {
    protected int[] stack;  
    private static final int DEFAULT_SIZE = 2;
    private int ptr = -1;

    public Stack(){
        this.stack = new int[DEFAULT_SIZE];
    }

    private boolean isFull(){
        return ptr == stack.length - 1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

    private void reSize(){
        int[] newStack = new int[stack.length * 2];
        for(int i = 0; i < stack.length; i++)
            newStack[i] = stack[i];
        
        this.stack = newStack;
    }

    public boolean push(int val){
        if(isFull())
            reSize();

        stack[++ptr] = val;
        return true;
    }

    public int pop(){
        if(isEmpty())
            return -1;

        return stack[ptr--];
    }

    public int peek(){
        if(isEmpty())
            return -1;

        return stack[ptr];
    }
}
