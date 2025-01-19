package ru.job4j.parking.strategy.remove;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.List;

public interface RemoveVehicleStrategy {
    boolean removeVehicle(List<ParkingSpot> parkingSpots, Vehicle vehicle);
}
