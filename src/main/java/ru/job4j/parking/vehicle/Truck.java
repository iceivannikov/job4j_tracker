package ru.job4j.parking.vehicle;

import ru.job4j.parking.util.VehicleType;

public class Truck extends AbstractVehicle {

    public Truck(int size) {
        super(size);
        if (size < 2) {
            throw new IllegalArgumentException("The size cannot be less than 2");
        }
    }

    @Override
    public String getType() {
        return VehicleType.TRUCK;
    }
}
