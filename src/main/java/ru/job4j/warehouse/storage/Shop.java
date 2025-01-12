package ru.job4j.warehouse.storage;

import ru.job4j.warehouse.model.Food;
import ru.job4j.warehouse.util.ShelfLife;

public class Shop extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        return ShelfLife.remaining(food) <= FRESHNESS_THRESHOLD_HIGH;
    }

    @Override
    public void add(Food food) {
        if (ShelfLife.remaining(food) <= FRESHNESS_THRESHOLD_LOW) {
            double newPrice = food.getPrice() * DISCOUNT_PERCENTAGE;
            food.setPrice(newPrice);
        }
        super.add(food);
    }
}
