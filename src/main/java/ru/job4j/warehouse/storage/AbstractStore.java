package ru.job4j.warehouse.storage;

import ru.job4j.warehouse.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
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
}
