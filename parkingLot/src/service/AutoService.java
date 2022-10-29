package service;

import Model.Auto;

public class AutoService {

    Auto auto;
    public Auto addAuto(String color, String number, String model)
    {
        auto=new Auto(color,number,model);
        return auto;
    }
}
