package ru.job4j.warehouse.storage;

import ru.job4j.warehouse.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected static final int MIN_FRESHNESS = 0;
    protected static final int FRESHNESS_THRESHOLD_HIGH = 75;
    protected static final int FRESHNESS_THRESHOLD_LOW = 25;
    protected static final double DISCOUNT_PERCENTAGE = 0.8;

    List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (food != null) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public void clear() {
        foods.clear();
    }
}
