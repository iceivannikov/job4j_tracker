package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость 800 км/ч");
    }
}
