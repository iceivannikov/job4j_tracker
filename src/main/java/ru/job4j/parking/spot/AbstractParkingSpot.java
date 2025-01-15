package ru.job4j.parking.spot;

import ru.job4j.parking.vehicle.Vehicle;

public class AbstractParkingSpot implements ParkingSpot {
    private boolean isOccupied = false;

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean canFitSpot(Vehicle vehicle) {
        return false;
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

    }

    @Override
    public void removeVehicle() {

    }

    @Override
    public ParkingSpot getType() {
        return this;
    }
}
