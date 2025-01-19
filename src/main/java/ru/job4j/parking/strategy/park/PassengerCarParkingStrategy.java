package ru.job4j.parking.strategy.park;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.util.ParkingSpotType;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.List;

public class PassengerCarParkingStrategy implements ParkingStrategy {
    public boolean park(Vehicle vehicle, List<ParkingSpot> spots) {
        boolean result = false;
        for (ParkingSpot spot : spots) {
            if (ParkingSpotType.PASSENGER_CAR_SPOT.equals(spot.getType())
                    && !spot.isOccupied()
                    && spot.canFitSpot(vehicle)) {
                spot.parkVehicle(vehicle);
                result = true;
                break;
            }
        }
        return result;
    }
}
