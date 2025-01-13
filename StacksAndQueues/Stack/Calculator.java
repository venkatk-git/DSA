package StacksAndQueues.Stack;

import cputils.FastReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public static void main(String[] agrs) {
        FastReader fastReader = new FastReader();
        String s = fastReader.nextLine();

        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        int total = 0;
        int curr = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                curr = (curr * 10) + (c - '0');
            } else if (c == '+' || c == '-') {
                total += (sign * curr);
                curr = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(total);
                stack.push(sign);
                total = 0;
                sign = 1;
            } else if (c == ')') {
                total += (curr * sign);
                total *= stack.pop();
                total += stack.pop();
                curr = 0;
            }
        }

        if (curr != 0) total += (curr * sign);

        return total;
    }
}