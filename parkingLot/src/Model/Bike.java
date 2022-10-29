package Model;

import Model.Vehicle;

public class Bike implements Vehicle {

    String color;
    String number;
    String model;
    type vehicleType;

    public Bike(String color, String number, String model) {
        this.color = color;
        this.number = number;
        this.model = model;
        vehicleType= type.BIKE;
    }

    @Override
    public type getType() {
        return vehicleType;
    }
}
