package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("one"),
                new Item("two"),
                new Item("three"),
                new Item("four"),
                new Item("five"),
                new Item("six")
        );
        items.sort(new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item("five"),
                new Item("four"),
                new Item("one"),
                new Item("six"),
                new Item("three"),
                new Item("two")
        );
        assertThat(items).usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(expected);
    }
}