package ru.job4j.parking;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParkingLot implements ParkingLot {
    private final int spotsPassengerCars;
    private final int spotsTrucks;
    private final List<ParkingSpot> parkingSpots;

    protected AbstractParkingLot(int spotsPassengerCars, int spotsTrucks) {
        this.spotsPassengerCars = spotsPassengerCars;
        this.spotsTrucks = spotsTrucks;
        this.parkingSpots = new ArrayList<>(spotsPassengerCars + spotsTrucks);
        init();
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

    }

    @Override
    public void removeVehicle(Vehicle vehicle) {

    }

    @Override
    public int getAvailableTruckSpotsCount() {
        return spotsTrucks;
    }

    @Override
    public int getAvailablePassengerCarsSpotsCount() {
        return spotsPassengerCars;
    }

    private void init() {

    }
}
