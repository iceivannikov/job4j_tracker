package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("one"),
                new Item("two"),
                new Item("three"),
                new Item("four"),
                new Item("five"),
                new Item("six")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("two"),
                new Item("three"),
                new Item("six"),
                new Item("one"),
                new Item("four"),
                new Item("five")
        );
        assertThat(items).usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(expected);
    }
}