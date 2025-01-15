package ru.job4j.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.parking.vehicle.Car;
import ru.job4j.parking.vehicle.Truck;
import ru.job4j.parking.vehicle.Vehicle;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkingLotTest {
    @Test
    void whenParkCarThenNumberFreeParkingSpotsDecreases() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        parkingLot.parkVehicle(new Car());
        int spotsCount = parkingLot.getAvailablePassengerCarsSpotsCount();
        assertThat(spotsCount).isEqualTo(4);
    }

    @Test
    void whenCarRemovedThenFreeSpotsIncrease() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        Vehicle truck = new Truck(3);
        parkingLot.parkVehicle(truck);
        int spotsCount = parkingLot.getAvailableTruckSpotsCount();
        assertThat(spotsCount).isEqualTo(4);
        parkingLot.removeVehicle(truck);
        spotsCount = parkingLot.getAvailableTruckSpotsCount();
        assertThat(spotsCount).isEqualTo(5);
    }

    @Test
    void whenTruckTakesUp3PassengerSpotsNumberOfPassengerSpotsDecreasesBy3() {
        ParkingLot parkingLot = new OpenParking(10, 0);
        Vehicle truck = new Truck(3);
        parkingLot.parkVehicle(truck);
        int spotsCount = parkingLot.getAvailablePassengerCarsSpotsCount();
        assertThat(spotsCount).isEqualTo(7);
    }
}