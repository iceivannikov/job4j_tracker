package ru.job4j.warehouse.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.warehouse.model.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarehouseTest {
    @Test
    void whenFoodIsFreshThenAcceptReturnsTrue() {
        Warehouse warehouse = new Warehouse();
        Food freshFood = new Food(
                "Carrot",
                LocalDate.now().plusDays(20),
                LocalDate.now().minusDays(5),
                25.0,
                0.0f);
        assertTrue(warehouse.accept(freshFood));
    }

    @Test
    void whenFoodIsNotFreshThenAcceptReturnsFalse() {
        Warehouse warehouse = new Warehouse();
        Food notFreshFood = new Food(
                "Tomato",
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(20),
                30.0,
                0.0f);
        assertFalse(warehouse.accept(notFreshFood));
    }

    @Test
    void whenAddFoodThenFoodIsAdded() {
        Warehouse warehouse = new Warehouse();
        Food freshFood = new Food(
                "Carrot",
                LocalDate.now().plusDays(20),
                LocalDate.now().minusDays(5),
                25.0,
                0.0f);
        warehouse.add(freshFood);
        assertTrue(warehouse.findAll().contains(freshFood));
    }
}