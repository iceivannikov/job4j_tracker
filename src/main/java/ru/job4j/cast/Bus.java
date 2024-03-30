package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость 80 км/ч");
    }
}
