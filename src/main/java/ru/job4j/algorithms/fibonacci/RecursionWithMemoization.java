package ru.job4j.algorithms.fibonacci;

import java.util.Arrays;

public class RecursionWithMemoization {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibMemo(n, memo);
    }

    private int fibMemo(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        System.out.println(n);
        System.out.println(Arrays.toString(memo));
        return memo[n];
    }

    public static void main(String[] args) {
        RecursionWithMemoization memo = new RecursionWithMemoization();
        System.out.println(memo.fib(6));
    }
}
