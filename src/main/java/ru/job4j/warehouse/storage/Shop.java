package ru.job4j.warehouse.storage;

import ru.job4j.warehouse.model.Food;
import ru.job4j.warehouse.util.ShelfLife;

public class Shop extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        return ShelfLife.remaining(food) <= 75;
    }

    @Override
    public void add(Food food) {
        if (ShelfLife.remaining(food) <= 25) {
            double newPrice = food.getPrice() * 0.8;
            food.setPrice(newPrice);
        }
        super.add(food);
    }
}
