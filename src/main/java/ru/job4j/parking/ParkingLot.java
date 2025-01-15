package ru.job4j.parking;

import ru.job4j.parking.vehicle.Vehicle;

public interface ParkingLot {
    void parkVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);

    int getAvailableTruckSpotsCount();

    int getAvailablePassengerCarsSpotsCount();
}
