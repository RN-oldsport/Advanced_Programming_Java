package Generics;

public class Main {
    public static void main(String[] args) {

        Passenger p1 = new Passenger("Marina", "T1");
        Passenger p2 = new Passenger("Tina", "T2");
        Passenger p3 = new Passenger("Obama", "T3");

        Bus bus = new Bus(2);
        Taxi taxi = new Taxi(1);

        TransportSystem<Vehicle> system = new TransportSystem<>();

        system.addVehicle(bus);
        system.addVehicle(taxi);


        system.assignPassenger(p1, bus);
        system.assignPassenger(p2, bus);

        system.assignPassenger(p3, bus);
        system.assignPassenger(p3, taxi);

        system.showAll();
    }
}

