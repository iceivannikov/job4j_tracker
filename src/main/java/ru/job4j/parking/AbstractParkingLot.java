package ru.job4j.parking;

import ru.job4j.parking.spot.ParkingSpot;
import ru.job4j.parking.spot.PassengerCarSpot;
import ru.job4j.parking.spot.TruckSpot;
import ru.job4j.parking.strategy.park.ParkingStrategy;
import ru.job4j.parking.strategy.park.PassengerCarParkingStrategy;
import ru.job4j.parking.strategy.park.TruckParkingStrategy;
import ru.job4j.parking.strategy.remove.RemovePassengerCerStrategy;
import ru.job4j.parking.strategy.remove.RemoveTruckStrategy;
import ru.job4j.parking.strategy.remove.RemoveVehicleStrategy;
import ru.job4j.parking.util.ParkingSpotType;
import ru.job4j.parking.util.VehicleType;
import ru.job4j.parking.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractParkingLot implements ParkingLot {
    private final Map<String, ParkingStrategy> parkVehicleStrategies = new HashMap<>();
    private final Map<String, RemoveVehicleStrategy> removeVehicleStrategies = new HashMap<>();
    private final int spotsPassengerCars;
    private final int spotsTrucks;
    private final List<ParkingSpot> parkingSpots;

    protected AbstractParkingLot(int spotsPassengerCars, int spotsTrucks) {
        this.spotsPassengerCars = spotsPassengerCars;
        this.spotsTrucks = spotsTrucks;
        this.parkingSpots = new ArrayList<>(spotsPassengerCars + spotsTrucks);
        init();
        parkVehicleStrategies.put(VehicleType.CAR, new PassengerCarParkingStrategy());
        parkVehicleStrategies.put(VehicleType.TRUCK, new TruckParkingStrategy());
        removeVehicleStrategies.put(VehicleType.CAR, new RemovePassengerCerStrategy());
        removeVehicleStrategies.put(VehicleType.TRUCK, new RemoveTruckStrategy());
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        ParkingStrategy strategy = parkVehicleStrategies.get(vehicle.getType());
        if (strategy == null || !strategy.park(vehicle, parkingSpots)) {
            throw new IllegalStateException("No suitable parking spots available.");
        }
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        RemoveVehicleStrategy strategy = removeVehicleStrategies.get(vehicle.getType());
        if (strategy == null || !strategy.removeVehicle(parkingSpots, vehicle)) {
            throw new IllegalStateException("Vehicle not found in the parking lot.");
        }
    }

    @Override
    public int getAvailableTruckSpotsCount() {
        return getAvailableSpotsCount(ParkingSpotType.TRUCK_SPOT);
    }

    @Override
    public int getAvailablePassengerCarsSpotsCount() {
        return getAvailableSpotsCount(ParkingSpotType.PASSENGER_CAR_SPOT);
    }

    private void init() {
        for (int i = 0; i < spotsPassengerCars; i++) {
            parkingSpots.add(new PassengerCarSpot());
        }
        for (int i = 0; i < spotsTrucks; i++) {
            parkingSpots.add(new TruckSpot());
        }
    }

    private int getAvailableSpotsCount(String type) {
        return (int) parkingSpots.stream()
                .filter(spot -> type.equals(spot.getType()) && !spot.isOccupied())
                .count();
    }
}
