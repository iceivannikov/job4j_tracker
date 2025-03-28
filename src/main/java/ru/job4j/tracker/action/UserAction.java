package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.storage.MemTracker;
import ru.job4j.tracker.storage.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
