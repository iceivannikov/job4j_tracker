package ru.job4j.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.parking.vehicle.Car;
import ru.job4j.parking.vehicle.Truck;
import ru.job4j.parking.vehicle.Vehicle;

import static org.assertj.core.api.Assertions.*;

class ParkingLotTest {
    @Test
    void whenParkCarThenNumberFreeParkingSpotsDecreases() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        parkingLot.parkVehicle(new Car());
        int spotsCount = parkingLot.getAvailablePassengerCarsSpotsCount();
        assertThat(spotsCount).isEqualTo(9);
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

    @Test
    void whenAllSpotsAreOccupiedThenCannotPark() {
        ParkingLot parkingLot = new OpenParking(1, 0);
        parkingLot.parkVehicle(new Car());
        assertThatThrownBy(() -> parkingLot.parkVehicle(new Car()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("No suitable parking spots available.");
    }

    @Test
    void whenRemoveNonExistentVehicleThenThrowsException() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        Vehicle car = new Car();
        assertThatThrownBy(() -> parkingLot.removeVehicle(car))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Vehicle not found in the parking lot.");
    }

    @Test
    void whenTruckCannotFitOnPassengerSpotsThenThrowsException() {
        ParkingLot parkingLot = new OpenParking(2, 0);
        Vehicle truck = new Truck(3);
        assertThatThrownBy(() -> parkingLot.parkVehicle(truck))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("No suitable parking spots available.");
    }

    @Test
    void whenParkCarAndTruckThenFreeSpotsCountIsCorrect() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        parkingLot.parkVehicle(new Car());
        parkingLot.parkVehicle(new Truck(3));
        int passengerSpotsCount = parkingLot.getAvailablePassengerCarsSpotsCount();
        int truckSpotsCount = parkingLot.getAvailableTruckSpotsCount();
        assertThat(passengerSpotsCount).isEqualTo(9);
        assertThat(truckSpotsCount).isEqualTo(4);
    }

    @Test
    void whenTruckParksOnTruckSpotThenTruckSpotCountDecreases() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        Vehicle truck = new Truck(3);
        parkingLot.parkVehicle(truck);
        int spotsCount = parkingLot.getAvailableTruckSpotsCount();
        assertThat(spotsCount).isEqualTo(4);
    }

    @Test
    void whenTruckRemovedFromPassengerSpotsThenSpotsAreFree() {
        ParkingLot parkingLot = new OpenParking(10, 0);
        Vehicle truck = new Truck(3);
        parkingLot.parkVehicle(truck);
        parkingLot.removeVehicle(truck);
        int spotsCount = parkingLot.getAvailablePassengerCarsSpotsCount();
        assertThat(spotsCount).isEqualTo(10);
    }

    @Test
    void whenAllVehiclesRemovedThenAllSpotsAreFree() {
        ParkingLot parkingLot = new OpenParking(10, 5);
        parkingLot.parkVehicle(new Car());
        parkingLot.parkVehicle(new Truck(3));
        parkingLot.removeVehicle(new Car());
        parkingLot.removeVehicle(new Truck(3));
        int passengerSpotsCount = parkingLot.getAvailablePassengerCarsSpotsCount();
        int truckSpotsCount = parkingLot.getAvailableTruckSpotsCount();
        assertThat(passengerSpotsCount).isEqualTo(10);
        assertThat(truckSpotsCount).isEqualTo(5);
    }
}