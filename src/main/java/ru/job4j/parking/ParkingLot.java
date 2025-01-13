package ru.job4j.parking;

public interface ParkingLot {
    void parkVehicle(Vehicle vehicle);

    void removeVehicle(Vehicle vehicle);

    int getAvailableSpotsCount();

    int getTotalSpotsCount();
}
