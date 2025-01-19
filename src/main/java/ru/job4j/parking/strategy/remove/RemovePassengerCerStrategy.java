package ru.job4j.parking.strategy.remove;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.util.ParkingSpotType;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.List;

public class RemovePassengerCerStrategy implements RemoveVehicleStrategy {
    @Override
    public boolean removeVehicle(List<ParkingSpot> parkingSpots, Vehicle vehicle) {
        boolean vehicleRemoved = false;
        for (ParkingSpot spot : parkingSpots) {
            if (ParkingSpotType.PASSENGER_CAR_SPOT.equals(spot.getType())
                    && spot.isOccupied()
                    && spot.canFitSpot(vehicle)) {
                spot.removeVehicle();
                vehicleRemoved = true;
            }
        }
        return vehicleRemoved;
    }
}
