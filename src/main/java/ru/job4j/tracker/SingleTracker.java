package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.MemTracker;

import java.util.List;

public class SingleTracker {
    private static final SingleTracker INSTANCE = new SingleTracker();
    private final MemTracker tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}
