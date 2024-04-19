package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PopulationCalculationTest {

    @Test
    public void whenNoCitiesThanZero() {
        Country country = new Country(List.of(), "TestCountry");
        Stream<Country> countryStream = Stream.of(country);
        long result = PopulationCalculation.getSumPopulationFor(countryStream, 900);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenCitiesBelowThresholdThanZero() {
        City city1 = new City("City1", 500);
        City city2 = new City("City2", 700);
        Country country = new Country(List.of(city1, city2), "TestCountry");
        Stream<Country> countryStream = Stream.of(country);
        long result = PopulationCalculation.getSumPopulationFor(countryStream, 1000);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenAllCitiesAboveThresholdThanSum() {
        City city1 = new City("City1", 1500);
        City city2 = new City("City2", 1700);
        City city3 = new City("City3", 2000);
        Country country1 = new Country(List.of(city1, city2), "TestCountry1");
        Country country2 = new Country(List.of(city1), "TestCountry2");
        Country country3 = new Country(List.of(city3), "TestCountry3");
        Stream<Country> countryStream = Stream.of(country1, country2, country3);
        long result = PopulationCalculation.getSumPopulationFor(countryStream, 1000);
        assertThat(result).isEqualTo(6700);
    }

    @Test
    public void whenCitiesAboveThresholdThanSum() {
        City city1 = new City("City1", 1200);
        City city2 = new City("City2", 800);
        Country country = new Country(List.of(city1, city2), "TestCountry");
        Stream<Country> countryStream = Stream.of(country);
        long result = PopulationCalculation.getSumPopulationFor(countryStream, 1000);
        assertThat(result).isEqualTo(1200);
    }

    @Test
    public void whenMultipleCitiesAboveThresholdThanSum() {
        City city1 = new City("City1", 1200);
        City city2 = new City("City2", 800);
        City city3 = new City("City3", 1500);
        Country country1 = new Country(List.of(city1, city2), "TestCountry1");
        Country country2 = new Country(List.of(city3), "TestCountry2");
        Stream<Country> countryStream = Stream.of(country1, country2);
        long result = PopulationCalculation.getSumPopulationFor(countryStream, 1000);
        assertThat(result).isEqualTo(2700);
    }

    @Test
    public void whenAllCitiesBelowThresholdThanZero() {
        City city1 = new City("City1", 500);
        City city2 = new City("City2", 700);
        Country country1 = new Country(List.of(city1, city2), "TestCountry1");
        Country country2 = new Country(List.of(city1), "TestCountry2");
        Stream<Country> countryStream = Stream.of(country1, country2);
        long result = PopulationCalculation.getSumPopulationFor(countryStream, 1000);
        assertThat(result).isEqualTo(0);
    }
}