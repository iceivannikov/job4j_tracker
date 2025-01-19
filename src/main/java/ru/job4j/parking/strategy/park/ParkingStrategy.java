package ru.job4j.parking.strategy.park;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    boolean park(Vehicle vehicle, List<ParkingSpot> spots);
}
