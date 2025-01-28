package ru.job4j.warehouse.storage;

import ru.job4j.warehouse.model.Food;

import java.util.List;

public interface Store {

    void add(Food food);

    List<Food> findAll();

    boolean accept(Food food);

    void clear();
}
