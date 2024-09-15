package StacksAndQueues.Stack.AsteroidCollision.java;

import java.util.*;

public abstract class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteriods = {-2,-2,1,-2};

        System.out.println(Arrays.toString(asteroidCollision(asteriods)));
    }

    public static int[] asteroidCollision(int[] asteroids){
        Deque<Integer> stack = new ArrayDeque<>();

        for(int asteroid: asteroids){
            if(asteroid > 0)    
                stack.push(asteroid);
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek())
                    stack.pop();
                if(!stack.isEmpty() && Math.abs(asteroid) == stack.peek())
                    stack.pop();
                else if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
            }
        }

        int[] remainingAsteroids = new int[stack.size()];
        int i = stack.size() - 1;

        for(Integer asteroid : stack)
            remainingAsteroids[i--] = asteroid;

        return remainingAsteroids;
    }

    public static boolean signDifference(int a, int b){
        return a < 0 && b > 0;
    }
}
