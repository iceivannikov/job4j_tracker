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

class DeleteActionTest {
    @Test
    void whenDeleteItemSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));

        DeleteAction action = new DeleteAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString())
                .isEqualTo("=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln);
    }

    @Test
    void whenDeleteItemFailure() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        DeleteAction action = new DeleteAction(output);

        Input input = mock(Input.class);
        int notExistingId = 10;
        when(input.askInt(any(String.class))).thenReturn(notExistingId);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString())
                .isEqualTo("=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки." + ln);
    }

}