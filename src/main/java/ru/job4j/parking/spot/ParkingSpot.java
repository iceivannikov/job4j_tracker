package ru.job4j.parking.spot;

import ru.job4j.parking.vehicle.Vehicle;

public interface ParkingSpot {
    boolean isOccupied();

    boolean canFitSpot(Vehicle vehicle);

    void parkVehicle(Vehicle vehicle);

    void removeVehicle();

    ParkingSpot getType();
}
