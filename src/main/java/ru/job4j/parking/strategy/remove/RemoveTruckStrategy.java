package ru.job4j.parking.strategy.remove;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.util.ParkingSpotType;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.List;

public class RemoveTruckStrategy implements RemoveVehicleStrategy {
    @Override
    public boolean removeVehicle(List<ParkingSpot> parkingSpots, Vehicle vehicle) {
        int requiredSpots = vehicle.getSize();
        boolean vehicleRemoved = false;
        for (ParkingSpot spot : parkingSpots) {
            if (ParkingSpotType.TRUCK_SPOT.equals(spot.getType()) && spot.isOccupied() && spot.canFitSpot(vehicle)) {
                spot.removeVehicle();
                vehicleRemoved = true;
            }
        }
        for (int i = 0; i <= parkingSpots.size() - requiredSpots; i++) {
            if (canRemoveTruckFromPassengerSpots(parkingSpots, i, requiredSpots)) {
                for (int j = 0; j < requiredSpots; j++) {
                    parkingSpots.get(i + j).removeVehicle();
                }
                vehicleRemoved = true;
            }
        }
        return vehicleRemoved;
    }

    private boolean canRemoveTruckFromPassengerSpots(List<ParkingSpot> parkingSpots,
                                                     int startIndex,
                                                     int requiredSpots) {
        boolean result = true;
        for (int i = 0; i < requiredSpots; i++) {
            ParkingSpot spot = parkingSpots.get(startIndex + i);
            if (!ParkingSpotType.PASSENGER_CAR_SPOT.equals(spot.getType()) || !spot.isOccupied()) {
                result = false;
            }
        }
        return result;
    }
}