package ru.job4j.parking.vehicle;

public class Truck extends AbstractVehicle {
    public Truck(int size) {
        super(size);
        if (size < 2) {
            throw new IllegalArgumentException("The size cannot be less than 2");
        }
    }
}
