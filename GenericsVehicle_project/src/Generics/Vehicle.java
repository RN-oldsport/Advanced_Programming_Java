package Generics;

import java.util.ArrayList;

abstract public class Vehicle {

    private String id;
    public int capacity;
    private ArrayList<Passenger> passengers;

    public Vehicle(int capacity) {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        this.id = generateID();
    }

    public abstract String generateID();


    public void addPassenger(Passenger passenger) {
        if (passengers.size() + 1 > capacity) {
            System.out.println("Vehicle is full");
            return;
        }
        passengers.add(passenger);
    }

    public int getRemainingCapacity() {
        return capacity - passengers.size();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + this.getID() + " capacity: " + " number of current passengers: " + passengers.size() + " list of passengers: " + this.getPassengers();
    }
}


class Bus extends Vehicle {
    private static int counter = 1;

    public Bus(int capacity) {
        super(capacity);
    }

    @Override
    public String generateID() {
        return "1" + String.format("%03d", counter++);
    }
}


class Taxi extends Vehicle {
    private static int counter = 1;
    public Taxi(int capacity) {
        super(capacity);
    }

    @Override
    public String generateID() {
        return "2" + String.format("%03d", counter++);
    }
}

