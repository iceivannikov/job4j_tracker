package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D(account, 1, 1, date));
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyTwiceOnSameSeatThenThrowException() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        cinema.buy(account1, 1, 1, date);
        assertThatThrownBy(() -> cinema.buy(account2, 1, 1, date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("already sold");
    }

    @Test
    public void whenBuyWithNullAccountThenThrowException() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(null, 1, 1, date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Account cannot be null");
    }

    @Test
    public void whenBuyWithNullDateThenThrowException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        assertThatThrownBy(() -> cinema.buy(account, 1, 1, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Date cannot be null");
    }

    @Test
    public void whenAddNullSessionThenThrowException() {
        Cinema cinema = new Cinema3D();
        assertThatThrownBy(() -> cinema.add(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Session cannot be null");
    }

    @Test
    public void whenFindWithFilterThenReturnMatchingSessions() {
        Cinema cinema = new Cinema3D();
        Session session1 = new Session3D();
        Session session2 = new Session3D();
        Session session3 = new Session3D();
        cinema.add(session1);
        cinema.add(session2);
        cinema.add(session3);
        List<Session> result = cinema.find(session -> session.equals(session2));
        assertThat(result).containsExactly(session2);
    }

    @Test
    public void whenFindWithFilterThatFindsNothingThenReturnEmptyList() {
        Cinema cinema = new Cinema3D();
        Session session1 = new Session3D();
        Session session2 = new Session3D();
        cinema.add(session1);
        cinema.add(session2);
        List<Session> result = cinema.find(session -> false);
        assertThat(result).isEmpty();
    }

    @Test
    public void whenFindWithNoSessionsThenReturnEmptyList() {
        Cinema cinema = new Cinema3D();
        List<Session> result = cinema.find(session -> true);
        assertThat(result).isEmpty();
    }
}