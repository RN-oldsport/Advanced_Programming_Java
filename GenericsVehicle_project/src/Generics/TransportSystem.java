package Generics;

import java.util.ArrayList;

public class TransportSystem<T extends Vehicle> {

    public ArrayList<T> vehiclesList = new ArrayList<>();

    public void addVehicle(T vehicle) {
        vehiclesList.add(vehicle);
    }

    public void assignPassenger(Passenger p, T vehicle) {
        vehicle.addPassenger(p);
    }

    public void showAll() {
        for (T v : vehiclesList) {
            System.out.println(v);
        }
    }
}


