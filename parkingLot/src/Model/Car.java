package Model;

import Model.Vehicle;

public class Car implements Vehicle {

    String color;
    String number;
    String model;
    type vehicleType;

    public Car(String color, String number, String model) {
        this.color = color;
        this.number = number;
        this.model = model;
        vehicleType= type.CAR;
    }

    @Override
    public type getType() {
        return vehicleType;
    }
}
