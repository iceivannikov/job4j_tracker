package ru.job4j.parking.spot;

import ru.job4j.parking.vehicle.Vehicle;

public abstract class AbstractParkingSpot implements ParkingSpot {
    private boolean isOccupied = false;

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        if (isOccupied) {
            throw new IllegalStateException("Parking spot is already occupied.");
        }
        isOccupied = true;
    }

    @Override
    public void removeVehicle() {
        if (!isOccupied) {
            throw new IllegalStateException("Parking spot is already empty.");
        }
        isOccupied = false;
    }
}
