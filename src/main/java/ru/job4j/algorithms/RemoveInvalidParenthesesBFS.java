package ru.job4j.algorithms;

import java.util.*;

public class RemoveInvalidParenthesesBFS {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (Objects.nonNull(s)) {
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            boolean foundValid = false;
            visited.add(s);
            queue.add(s);
            while (!queue.isEmpty()) {
                String curr = queue.poll();
                if (isValid(curr)) {
                    result.add(curr);
                    foundValid = true;
                }
                if (!foundValid) {
                    for (int i = 0; i < curr.length(); i++) {
                        char ch = curr.charAt(i);
                        if (ch == '(' || ch == ')') {
                            String next = curr.substring(0, i) + curr.substring(i + 1);
                            if (!visited.contains(next)) {
                                visited.add(next);
                                queue.add(next);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                if (balance == 0) {
                    return false;
                }
                balance--;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesesBFS solver = new RemoveInvalidParenthesesBFS();

        List<String> result1 = solver.removeInvalidParentheses("()())()");
        System.out.println(result1);

        List<String> result2 = solver.removeInvalidParentheses("(a)())()");
        System.out.println(result2);

        List<String> result3 = solver.removeInvalidParentheses(")(");
        System.out.println(result3);
    }
}
