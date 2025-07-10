package ru.job4j.algorithms.fibonacci;

public class IterativeCalculationWithOnlyTwoVariables {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0, second = 1;
        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        IterativeCalculationWithOnlyTwoVariables calculator = new IterativeCalculationWithOnlyTwoVariables();
        System.out.println(calculator.fib(7));
    }
}
