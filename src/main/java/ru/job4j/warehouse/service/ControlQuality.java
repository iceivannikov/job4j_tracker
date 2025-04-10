package ru.job4j.warehouse.service;

import ru.job4j.warehouse.model.Food;
import ru.job4j.warehouse.storage.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribute(Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.findAll());
            store.clear();
        }
        for (Food food : foods) {
            distribute(food);
        }
    }
}
