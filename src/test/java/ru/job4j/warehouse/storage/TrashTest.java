package ru.job4j.warehouse.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.warehouse.model.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrashTest {
    @Test
    void whenFoodIsExpiredThenAcceptReturnsTrue() {
        Trash trash = new Trash();
        Food expiredFood = new Food(
                "Milk",
                LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10),
                50.0,
                0.0f);
        assertTrue(trash.accept(expiredFood));
    }

    @Test
    void whenFoodIsNotExpiredThenAcceptReturnsFalse() {
        Trash trash = new Trash();
        Food validFood = new Food(
                "Apple",
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(5),
                30.0,
                0.0f);
        assertFalse(trash.accept(validFood));
    }

    @Test
    void whenAddFoodThenFoodIsAdded() {
        Trash trash = new Trash();
        Food expiredFood = new Food(
                "Milk",
                LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10),
                50.0,
                0.0f);
        trash.add(expiredFood);
        assertTrue(trash.findAll().contains(expiredFood));
    }
}