package service;

import Model.Car;

public class CarService {
    Car car;
    public Car addCar(String color, String number, String model)
    {
        car=new Car(color,number,model);
        return car;
    }
}
