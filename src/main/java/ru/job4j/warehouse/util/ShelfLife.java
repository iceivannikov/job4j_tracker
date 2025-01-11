package ru.job4j.warehouse.util;

import ru.job4j.warehouse.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShelfLife {
    public static long remaining(Food food) {
        long totalDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long elapsedDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        long result = Math.max(0, 100 - (elapsedDays * 100 / totalDays));
        if (totalDays <= 0) {
            result = 0;
        }
        return result;
    }
}
