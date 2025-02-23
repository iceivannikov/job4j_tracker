package ru.job4j.algorithms;

import java.util.Stack;

public class SimplifyPath {
    public String simplify(String path) {
        var stack = new Stack<String>();
        var components = path.split("/");
        for (var component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }
        var result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.isEmpty() ? "/" : result.toString();
    }
}
