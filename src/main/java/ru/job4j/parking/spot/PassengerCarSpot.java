package ru.job4j.parking.spot;

import ru.job4j.parking.util.ParkingSpotType;
import ru.job4j.parking.vehicle.Vehicle;

public class PassengerCarSpot extends AbstractParkingSpot {

    @Override
    public boolean canFitSpot(Vehicle vehicle) {
        return vehicle.getSize() == 1;
    }

    @Override
    public String getType() {
        return ParkingSpotType.PASSENGER_CAR_SPOT;
    }
}
