package StacksAndQueues.Stack.ValidParanthesis.java;

import java.util.Stack;

public class ValidParanthesis{
    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s){
        if(s.length() % 2 != 0)
            return false;

        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;


        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if(stack.isEmpty())
                    return false;

                if((ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '[') || (ch == '}' && stack.peek() == '{'))
                    stack.pop();
                else 
                    return false;
            }
        }

        return stack.isEmpty();
    }
}