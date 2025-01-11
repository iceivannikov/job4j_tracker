package ru.job4j.warehouse.service;

import org.junit.jupiter.api.Test;
import ru.job4j.warehouse.model.Food;
import ru.job4j.warehouse.storage.Shop;
import ru.job4j.warehouse.storage.Trash;
import ru.job4j.warehouse.storage.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {
    @Test
    void whenDistributeToTrash() {
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, warehouse, shop));
        Food expiredFood = new Food(
                "Milk",
                LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10),
                50.0,
                0.0f);
        controlQuality.distribute(expiredFood);
        assertTrue(trash.findAll().contains(expiredFood));
        assertFalse(warehouse.findAll().contains(expiredFood));
        assertFalse(shop.findAll().contains(expiredFood));
    }

    @Test
    void whenDistributeToWarehouse() {
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, warehouse, shop));
        Food freshFood = new Food(
                "Apple",
                LocalDate.now().plusDays(20),
                LocalDate.now().minusDays(5),
                30.0,
                0.0f);
        controlQuality.distribute(freshFood);
        assertTrue(warehouse.findAll().contains(freshFood));
        assertFalse(trash.findAll().contains(freshFood));
        assertFalse(shop.findAll().contains(freshFood));
    }

    @Test
    void whenDistributeToShopWithoutDiscount() {
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, warehouse, shop));
        Food normalFood = new Food(
                "Bread",
                LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(5),
                40.0,
                0.0f);
        controlQuality.distribute(normalFood);
        assertTrue(shop.findAll().contains(normalFood));
        assertFalse(trash.findAll().contains(normalFood));
        assertFalse(warehouse.findAll().contains(normalFood));
        assertEquals(40.0, normalFood.getPrice());
    }

    @Test
    void whenDistributeToShopWithDiscount() {
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(trash, warehouse, shop));
        Food discountedFood = new Food(
                "Yogurt",
                LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(8),
                50.0,
                0.0f);
        controlQuality.distribute(discountedFood);
        assertTrue(shop.findAll().contains(discountedFood));
        assertFalse(trash.findAll().contains(discountedFood));
        assertFalse(warehouse.findAll().contains(discountedFood));
        assertEquals(40.0, discountedFood.getPrice());
    }
}