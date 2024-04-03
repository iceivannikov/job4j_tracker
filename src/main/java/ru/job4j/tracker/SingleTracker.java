package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

public class SingleTracker {
    private static final Tracker INSTANCE = new Tracker();

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return INSTANCE.add(item);
    }

    public Item[] findAll() {
        return INSTANCE.findAll();
    }

    public Item[] findByName(String key) {
        return INSTANCE.findByName(key);
    }

    public Item findById(int id) {
        return INSTANCE.findById(id);
    }

    public boolean replace(int id, Item item) {
        return INSTANCE.replace(id, item);
    }

    public void delete(int id) {
        INSTANCE.delete(id);
    }
}
