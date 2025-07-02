package ru.job4j.algorithms;

public class Sqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        if (x >= 1) {
            while (left <= right) {
                int half = (right + left) / 2;
                long square = (long) half * half;
                if (x == square) {
                    return half;
                } else if (x < square) {
                    right = half - 1;
                } else {
                    left = half + 1;
                }
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(8));
    }
}
