package ru.job4j.queue;

import java.util.Objects;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i < count; i++) {
            queue.poll();
        }
        return getName();
    }

    public String getFirstUpsetCustomer() {
        for (int i = 1; i <= count; i++) {
            queue.poll();
        }
        return getName();
    }

    private String getName() {
        return Objects.requireNonNull(queue.poll()).name();
    }
}
