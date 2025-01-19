package ru.job4j.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.parking.vehicle.Car;
import ru.job4j.parking.vehicle.Truck;
import ru.job4j.parking.vehicle.Vehicle;

import static org.assertj.core.api.Assertions.*;

class VehicleTest {
    @Test
    void whenTruckSize3Then3() {
        Vehicle vehicle = new Truck(3);
        int size = vehicle.getSize();
        assertThat(size).isEqualTo(3);
    }

    @Test
    void whenGetSizePassengerCarThen1() {
        Vehicle vehicle = new Car();
        int size = vehicle.getSize();
        assertThat(size).isEqualTo(1);
    }

    @Test
    void whenVehiclePassengerCarThenPassengerCar() {
        Vehicle vehicle = new Car();
        String type = vehicle.getType();
        assertThat(type).isEqualTo("Car");
    }

    @Test
    void whenVehicleTruckThenTruck() {
        Vehicle vehicle = new Truck(2);
        String type = vehicle.getType();
        assertThat(type).isEqualTo("Truck");
    }

    @Test
    void whenTruckWithInvalidSizeCreatedThenThrowsException() {
        assertThatThrownBy(() -> new Truck(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The size cannot be less than 2");
    }
}