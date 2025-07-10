package ru.job4j.algorithms;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(5));
    }
}
