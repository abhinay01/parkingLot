package Model;

import Model.Vehicle;

public class Auto implements Vehicle {

    String color;
    String number;
    String model;
    Vehicle.type vehicleType;

    public Auto(String color, String number, String model) {
        this.color = color;
        this.number = number;
        this.model = model;
        vehicleType= type.AUTO;
    }

    @Override
    public Vehicle.type getType() {
        return vehicleType;
    }
}
