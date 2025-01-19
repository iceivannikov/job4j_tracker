package ru.job4j.parking.vehicle;

import ru.job4j.parking.util.VehicleType;

public class Car extends AbstractVehicle {

    public Car() {
        super(1);
    }

    @Override
    public String getType() {
        return VehicleType.CAR;
    }
}
