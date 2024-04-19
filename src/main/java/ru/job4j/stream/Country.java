package ru.job4j.stream;

import java.util.List;

public record Country(List<City> cities, String name) {
}
