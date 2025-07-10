package ru.job4j.algorithms.fibonacci;

public class SimpleRecursiveMethod {

    public int fib1(int n) {
        if (n == 1) {
            System.out.println(n);
            return 1;
        }
        if (n == 0) {
            System.out.println(n);
            return 0;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static void main(String[] args) {
        SimpleRecursiveMethod simpleRecursiveMethod = new SimpleRecursiveMethod();
        simpleRecursiveMethod.fib1(5);
    }
}
