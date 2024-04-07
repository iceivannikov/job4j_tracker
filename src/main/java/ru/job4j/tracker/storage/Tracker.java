package ru.job4j.tracker.storage;

import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        Item replace = findById(id);
        if (replace != null) {
            replace.setName(item.getName());
            result = true;
        }
        return result;
    }

    public void delete(int id) {
        items.remove(findById(id));
    }
}