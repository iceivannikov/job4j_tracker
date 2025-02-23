package ru.job4j.algorithms;

import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }
                char lastOpen = stack.pop();
                if ((c == '}' && lastOpen != '{')
                        || (c == ']' && lastOpen != '[')
                        || (c == ')' && lastOpen != '(')) {
                    result = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
}