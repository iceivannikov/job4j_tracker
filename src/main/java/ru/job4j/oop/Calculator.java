package ru.job4j.oop;

public class Calculator {
    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public int multiply(int y) {
        return X * y;
    }

    public static int minus(int y) {
        return X - y;
    }

    public int divide(int y) {
        return y / X;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        System.out.println(Calculator.minus(10));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(5));
        System.out.println(calculator.divide(5));
        System.out.println(calculator.sumAllOperation(100));
    }
}
