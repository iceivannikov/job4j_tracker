package ru.job4j.ood.tdd;

import java.util.*;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    private final List<Session> sessions = new ArrayList<>();
    private final Map<String, Ticket> soldTickets = new HashMap<>();

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return sessions.stream().filter(filter).toList();
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("Row and column must be positive");
        }
        if (Objects.isNull(date)) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        String ticketKey = generateTicketKey(row, column, date);
        if (soldTickets.containsKey(ticketKey)) {
            throw new IllegalArgumentException("already sold");
        }
        if (Objects.isNull(account)) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        Ticket3D ticket = new Ticket3D(account, row, column, date);
        soldTickets.put(ticketKey, ticket);
        return ticket;
    }

    @Override
    public void add(Session session) {
        if (Objects.isNull(session)) {
            throw new IllegalArgumentException("Session cannot be null");
        }
        sessions.add(session);
    }

    private String generateTicketKey(int row, int column, Calendar date) {
        return row + ":" + column + ":" + date.getTimeInMillis();
    }
}
