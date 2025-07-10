package ru.job4j.algorithms.fibonacci;

public class IterativeApproach {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IterativeApproach approach = new IterativeApproach();
        System.out.println(approach.fib(20));
    }
}
