package ru.job4j.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.parking.spot.PassengerCarSpot;
import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.spot.TruckSpot;
import ru.job4j.parking.vehicle.Car;
import ru.job4j.parking.vehicle.Truck;
import ru.job4j.parking.vehicle.Vehicle;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkingSpotTest {
    @Test
    void whenParkingVehicleThenParkingPlaceIsOccupiedThenTrue() {
        ParkingSpot parkingSpot = new TruckSpot();
        Vehicle truck = new Truck(3);
        parkingSpot.parkVehicle(truck);
        assertThat(parkingSpot.isOccupied()).isTrue();
    }

    @Test
    void whenRemoveVehicleThenParkingPlaceIsNotOccupiedThenFalse() {
        ParkingSpot parkingSpot = new PassengerCarSpot();
        Vehicle car = new Car();
        parkingSpot.parkVehicle(car);
        parkingSpot.removeVehicle();
        assertThat(parkingSpot.isOccupied()).isFalse();
    }

    @Test
    void whenParkingPlaceCargoThenTypeCargo() {
        ParkingSpot parkingSpot = new PassengerCarSpot();
        ParkingSpot type = parkingSpot.getType();
        assertThat(type).isEqualTo(parkingSpot);
    }

    @Test
    void whenSpotIsSuitableForVehicleThenTrue() {
        ParkingSpot parkingSpot = new TruckSpot();
        Vehicle truck = new Truck(3);
        boolean canFitSpot = parkingSpot.canFitSpot(truck);
        assertThat(canFitSpot).isTrue();
    }

    @Test
    void whenSpotIsNotSuitableForVehicleThenFalse() {
        ParkingSpot parkingSpot = new PassengerCarSpot();
        Vehicle truck = new Truck(3);
        boolean canFitSpot = parkingSpot.canFitSpot(truck);
        assertThat(canFitSpot).isFalse();
    }
}