package ru.job4j.warehouse.storage;

import ru.job4j.warehouse.model.Food;
import ru.job4j.warehouse.util.ShelfLife;

public class Trash extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        return ShelfLife.remaining(food) == 0;
    }
}
