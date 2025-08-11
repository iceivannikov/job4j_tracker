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

class FindByIdActionTest {

    @Test
    void whenFindByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));

        FindByIdAction action = new FindByIdAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString())
                .startsWith("=== Вывод заявки по id ===" + ln)
                .contains(item.getName());
    }

    @Test
    void whenFindByIdThenReturnNotFoundMessage() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        int notFoundId = 100;

        FindByIdAction action = new FindByIdAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(notFoundId);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString())
                .isEqualTo("=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: " + notFoundId + " не найдена." + ln);
    }
}