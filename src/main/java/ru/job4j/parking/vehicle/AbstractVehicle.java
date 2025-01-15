package ru.job4j.parking.vehicle;

public abstract class AbstractVehicle implements Vehicle {
    private final int size;

    public AbstractVehicle(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Vehicle getType() {
        return this;
    }
}
