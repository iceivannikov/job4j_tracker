package ru.job4j.parking;

public interface ParkingSpot {
    boolean isOccupied();

    boolean canFitVehicle(Vehicle vehicle);

    void parkVehicle(Vehicle vehicle);

    void removeVehicle();

    String getType();
}
