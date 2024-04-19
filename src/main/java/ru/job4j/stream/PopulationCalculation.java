package ru.job4j.stream;

import java.util.stream.Stream;

public class PopulationCalculation {
    static long getSumPopulationFor(Stream<Country> countryStream, int populationThreshold) {
        return countryStream.flatMap(country -> country.cities().stream())
                .filter(city -> city.population() > populationThreshold)
                .mapToInt(City::population)
                .sum();
    }
}
