package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int passengers) {
        System.out.printf("В автобус помещается %d пассажиров", passengers);
    }

    @Override
    public double fillUp(int fuel) {
        return fuel * 2.34;
    }
}
