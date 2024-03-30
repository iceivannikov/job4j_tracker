package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle bus3 = new Bus();
        Vehicle airplane1 = new Airplane();
        Vehicle airplane2 = new Airplane();
        Vehicle airplane3 = new Airplane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle train3 = new Train();
        Vehicle[] vehicles = new Vehicle[]{bus1, bus2, bus3, airplane1, airplane2, airplane3, train1, train2, train3};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.maxSpeed();
        }
    }
}
