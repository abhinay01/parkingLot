package service;

import Model.Bike;

public class BikeService {
    Bike bike;
    public Bike addBike(String color, String number, String model)
    {
        bike=new Bike(color,number,model);
        return bike;
    }
}
