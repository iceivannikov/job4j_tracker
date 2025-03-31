package ru.job4j.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParenthesesRecursion {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int[] removals = getMinRemovals(s);
        backtrack(s, 0, 0, removals[0], removals[1], new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private int[] getMinRemovals(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return new int[]{left, right};
    }

    private void backtrack(String s, int index, int balance, int leftRem,
                           int rightRem, StringBuilder path, Set<String> result) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && balance == 0) {
                result.add(path.toString());
            }
            return;
        }
        char c = s.charAt(index);
        int length = path.length();
        if (c == '(') {
            if (leftRem > 0) {
                backtrack(s, index + 1, balance, leftRem - 1, rightRem, path, result);
            }
            path.append(c);
            backtrack(s, index + 1, balance + 1, leftRem, rightRem, path, result);
            path.setLength(length);
        } else if (c == ')') {
            if (rightRem > 0) {
                backtrack(s, index + 1, balance, leftRem, rightRem - 1, path, result);
            }
            if (balance > 0) {
                path.append(c);
                backtrack(s, index + 1, balance - 1, leftRem, rightRem, path, result);
                path.setLength(length);
            }
        } else {
            path.append(c);
            backtrack(s, index + 1, balance, leftRem, rightRem, path, result);
            path.setLength(length);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesesRecursion solver = new RemoveInvalidParenthesesRecursion();
        System.out.println("🔽 Результаты:");
        System.out.println(solver.removeInvalidParentheses("()())()"));
    }
}
