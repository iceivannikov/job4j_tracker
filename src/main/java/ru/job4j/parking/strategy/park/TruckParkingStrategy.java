package ru.job4j.parking.strategy.park;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.util.ParkingSpotType;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.List;

public class TruckParkingStrategy implements ParkingStrategy {
    @Override
    public boolean park(Vehicle vehicle, List<ParkingSpot> spots) {
        boolean result;
        result = parkOnTruckSpot(vehicle, spots);
        if (!result) {
            result = parkOnPassengerSpots(vehicle, spots);
        }
        return result;
    }

    private boolean parkOnTruckSpot(Vehicle vehicle, List<ParkingSpot> spots) {
        boolean result = false;
        for (ParkingSpot spot : spots) {
            if (ParkingSpotType.TRUCK_SPOT.equals(spot.getType()) && !spot.isOccupied() && spot.canFitSpot(vehicle)) {
                spot.parkVehicle(vehicle);
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean parkOnPassengerSpots(Vehicle vehicle, List<ParkingSpot> spots) {
        boolean result = false;
        int requiredSpots = vehicle.getSize();
        for (int i = 0; i <= spots.size() - requiredSpots; i++) {
            if (canParkTruckInPassengerSpots(spots, i, requiredSpots)) {
                for (int j = 0; j < requiredSpots; j++) {
                    spots.get(i + j).parkVehicle(vehicle);
                }
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean canParkTruckInPassengerSpots(List<ParkingSpot> spots, int startIndex, int requiredSpots) {
        boolean result = true;
        for (int i = 0; i < requiredSpots; i++) {
            ParkingSpot spot = spots.get(startIndex + i);
            if (!ParkingSpotType.PASSENGER_CAR_SPOT.equals(spot.getType()) || spot.isOccupied()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
