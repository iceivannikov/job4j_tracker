package ru.job4j.stream;

import java.util.stream.Stream;

public enum Suit {
    DIAMONDS,
    HEARTS,
    SPADES,
    CLUBS
}

enum Value {
    V_6,
    V_7,
    V_8
}

class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .flatMap(value -> Stream.of(new Card(suit, value))))
                .forEach(System.out::println);
    }
}