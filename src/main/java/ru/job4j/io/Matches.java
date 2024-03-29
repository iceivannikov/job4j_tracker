package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            if (input.hasNextInt()) {
                int matches = input.nextInt();
                if (matches > 0 && matches < 4 && count >= matches) {
                    count -= matches;
                    System.out.printf("На столе осталось %d спичек\n", count);
                    turn = !turn;
                } else {
                    System.out.println("Число должно быть от 1 до 3 и число не может превышать остаток спичек");
                    input.nextLine();
                }
            } else {
                System.out.println("Ошибка: введено не число. Пожалуйста, введите число от 1 до 3.");
                input.nextLine();
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
