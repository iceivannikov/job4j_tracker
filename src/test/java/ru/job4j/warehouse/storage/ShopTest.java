package ru.job4j.warehouse.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.warehouse.model.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    @Test
    void whenFoodIsSuitableForShopThenAcceptReturnsTrue() {
        Shop shop = new Shop();
        Food suitableFood = new Food(
                "Bread",
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(5),
                40.0,
                0.0f);
        assertTrue(shop.accept(suitableFood));
    }

    @Test
    void whenFoodIsNotSuitableForShopThenAcceptReturnsFalse() {
        Shop shop = new Shop();
        Food unsuitableFood = new Food(
                "Bread",
                LocalDate.now().plusDays(20),
                LocalDate.now().minusDays(2),
                40.0,
                0.0f);
        assertFalse(shop.accept(unsuitableFood));
    }

    @Test
    void whenAddFoodWithLowRemainingThenPriceIsDiscounted() {
        Shop shop = new Shop();
        Food discountedFood = new Food(
                "Yogurt",
                LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(8),
                50.0,
                0.0f);
        shop.add(discountedFood);
        assertEquals(40.0, discountedFood.getPrice());
    }

    @Test
    void whenAddFoodThenFoodIsAdded() {
        Shop shop = new Shop();
        Food normalFood = new Food(
                "Cheese",
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(5),
                80.0,
                0.0f);
        shop.add(normalFood);
        assertTrue(shop.findAll().contains(normalFood));
    }
}