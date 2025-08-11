package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.storage.MemTracker;
import ru.job4j.tracker.storage.Store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    @Test
    void whenFindByNameThenReturnListItems() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));
        Item item1 = tracker.add(new Item("Item 1"));
        Item item2 = tracker.add(new Item("Item 2"));

        FindByNameAction action = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString())
                .startsWith(
                        "=== Вывод заявок по имени ===" + ln
                )
                .contains(item.getName())
                .doesNotContain(item1.getName(), item2.getName());
    }

    @Test
    void whenFindByNameThenReturnNotFoundMessage() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));
        Item item1 = tracker.add(new Item("Item 1"));
        Item item2 = tracker.add(new Item("Item 2"));
        String notFoundName = "Not found";

        String ln = System.lineSeparator();

        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(notFoundName);

        findByNameAction.execute(input, tracker);

        assertThat(output.toString())
                .isEqualTo("=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: " + notFoundName + " не найдены." + ln)
                .doesNotContain(item.getName(), item1.getName(), item2.getName());
    }
}