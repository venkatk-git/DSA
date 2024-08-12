package StacksAndQueues.Stack.Implementation.java;

public class Main{
    public static void main(String[] args) {
        Stack stack = new Stack();
        
        for(int i = 1; i <= 50; i++)
            stack.push(i);

        for(int i = 1; i <= 50; i++)
            System.out.println(stack.pop());
    }
}